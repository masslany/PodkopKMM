package pl.masslany.network.infrastructure

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.util.reflect.TypeInfo
import pl.masslany.network.api.ApiClient
import pl.masslany.network.infrastructure.mapper.RequestToKtorRequestBuilderMapper
import pl.masslany.network.models.request.Request
import pl.masslany.network.models.response.ApiResponse
import pl.masslany.network.models.response.ResponseTypeInfo

class ApiClientImpl(
    private val httpClient: HttpClient,
    private val requestToKtorRequestBuilderMapper: RequestToKtorRequestBuilderMapper,
) : ApiClient() {
    override suspend fun <T> executeRequest(
        request: Request<T>,
        responseType: ResponseTypeInfo,
    ): Result<ApiResponse<T>> {
        return try {
            val requestBuilder = requestToKtorRequestBuilderMapper.map(request)
            val httpResponse = httpClient.request(requestBuilder)

            val responseBody =
                httpResponse.body(
                    TypeInfo(
                        responseType.type,
                        responseType.reifiedType,
                        responseType.kotlinType,
                    ),
                ) as T

            Result.success(ApiResponse(content = responseBody))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
