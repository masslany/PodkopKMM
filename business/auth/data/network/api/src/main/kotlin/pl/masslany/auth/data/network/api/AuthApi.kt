package pl.masslany.auth.data.network.api

import pl.masslany.auth.data.network.models.AuthDto
import pl.masslany.auth.data.network.models.RefreshDto
import pl.masslany.auth.data.network.models.WykopConnectDto

interface AuthApi {
    suspend fun getAuthToken(
        key: String,
        secret: String,
    ): Result<AuthDto>

    suspend fun getWykopConnect(): Result<WykopConnectDto>

    suspend fun refreshTokens(refreshToken: String): Result<RefreshDto>

    suspend fun logout(): Result<Unit>
}
