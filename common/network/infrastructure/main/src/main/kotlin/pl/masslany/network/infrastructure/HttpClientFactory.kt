package pl.masslany.network.infrastructure

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import pl.masslany.common.configstorage.api.ConfigStorage
import pl.masslany.network.api.RefreshTokensEventReducer
import pl.masslany.network.models.refresh.RefreshAction

class HttpClientFactory(
    private val cfgStorage: ConfigStorage,
    private val refreshTokensEventReducer: RefreshTokensEventReducer,
) {
    fun create(): HttpClient {
        return HttpClient(Android) {
            defaultRequest {
                url("https://wykop.pl/")
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                    },
                )
            }

            install(DefaultRequest) {
                contentType(ContentType.Application.Json)
            }

            install(bearerTokenInterceptor) {
                this.configStorage = cfgStorage
            }

            install(HttpRequestRetry) {
                maxRetries = MAX_RETRY_COUNT
                retryIf { _, httpResponse -> httpResponse.status == HttpStatusCode.Forbidden }
                delayMillis { retry -> retry * DELAY_MILLIS }
                modifyRequest {
                    runBlocking {
                        /*
                         * This still feels like a hacky approach to a scenario where token expires
                         * during a session. We want to refresh the token seamlessly during it.
                         * Maybe future me has a better knowledge on how to handle it.
                         * */
                        withContext(Dispatchers.Default) {
                            refreshTokensEventReducer.reduce(RefreshAction.Refresh)
                        }
                        val token = cfgStorage.getBearerToken()
                        if (token.isNotEmpty()) {
                            it.headers[HttpHeaders.Authorization] = "Bearer $token"
                        }
                    }
                }
            }

            install(Logging) {
                logger = AndroidLogger()
                level = LogLevel.ALL
            }
        }
    }

    private companion object {
        const val MAX_RETRY_COUNT = 3
        const val DELAY_MILLIS = 500L
    }
}
