package pl.masslany.network.infrastructure.mapper

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import io.ktor.util.reflect.TypeInfo
import pl.masslany.network.models.request.Request

class RequestToKtorRequestBuilderMapper {
    fun <T> map(param: Request<T>): HttpRequestBuilder {
        return HttpRequestBuilder().apply {
            val formattedPath =
                when {
                    param.path.contains("://") || param.path.startsWith("/") -> param.path
                    else -> "/${param.path}"
                }
            url(formattedPath)

            method = param.method.toKtorHttpMethod()

            param.queryParameters?.forEach { param ->
                parameter(param.key, param.value)
            }

            param.headers?.forEach { (key, value) ->
                header(key, value)
            }

            param.body?.let { requestBody ->
                val requestBodyType =
                    TypeInfo(
                        type = requestBody::class,
                        reifiedType = requestBody::class.java,
                    )

                setBody(requestBody, requestBodyType)
            }
        }
    }

    private fun Request.HttpMethod.toKtorHttpMethod(): HttpMethod {
        return when (this) {
            Request.HttpMethod.GET -> HttpMethod.Get
            Request.HttpMethod.DELETE -> HttpMethod.Delete
            Request.HttpMethod.PATCH -> HttpMethod.Patch
            Request.HttpMethod.POST -> HttpMethod.Post
            Request.HttpMethod.PUT -> HttpMethod.Put
        }
    }
}
