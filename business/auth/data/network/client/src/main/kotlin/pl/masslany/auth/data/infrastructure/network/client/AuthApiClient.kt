package pl.masslany.auth.data.infrastructure.network.client

import pl.masslany.auth.data.network.api.AuthApi
import pl.masslany.auth.data.network.models.AuthDto
import pl.masslany.auth.data.network.models.AuthRequestData
import pl.masslany.auth.data.network.models.AuthRequestDto
import pl.masslany.auth.data.network.models.RefreshDto
import pl.masslany.auth.data.network.models.RefreshRequestData
import pl.masslany.auth.data.network.models.RefreshRequestDto
import pl.masslany.auth.data.network.models.WykopConnectDto
import pl.masslany.network.api.ApiClient
import pl.masslany.network.api.request
import pl.masslany.network.models.request.Request

class AuthApiClient(
    private val apiClient: ApiClient,
) : AuthApi {
    override suspend fun getAuthToken(
        key: String,
        secret: String,
    ): Result<AuthDto> {
        val body =
            AuthRequestDto(
                data =
                    AuthRequestData(
                        key = key,
                        secret = secret,
                    ),
            )
        val request =
            Request<AuthDto>(
                method = Request.HttpMethod.POST,
                path = "api/v3/auth",
                body = body,
            )

        return apiClient.request(request).fold(
            onSuccess = { Result.success(it.content) },
            onFailure = { Result.failure(it) },
        )
    }

    override suspend fun getWykopConnect(): Result<WykopConnectDto> {
        val request =
            Request<WykopConnectDto>(
                method = Request.HttpMethod.GET,
                path = "api/v3/connect",
            )

        return apiClient.request(request).fold(
            onSuccess = { Result.success(it.content) },
            onFailure = { Result.failure(it) },
        )
    }

    override suspend fun refreshTokens(refreshToken: String): Result<RefreshDto> {
        val body =
            RefreshRequestDto(
                data = RefreshRequestData(refreshToken = refreshToken),
            )
        val request =
            Request<RefreshDto>(
                method = Request.HttpMethod.POST,
                path = "api/v3/refresh-token",
                body = body,
            )

        return apiClient.request(request).fold(
            onSuccess = { Result.success(it.content) },
            onFailure = { Result.failure(it) },
        )
    }

    override suspend fun logout(): Result<Unit> {
        val request =
            Request<Unit>(
                method = Request.HttpMethod.GET,
                path = "api/v3/logout",
            )

        return apiClient.request(request).fold(
            onSuccess = { Result.success(Unit) },
            onFailure = { Result.failure(it) },
        )
    }
}
