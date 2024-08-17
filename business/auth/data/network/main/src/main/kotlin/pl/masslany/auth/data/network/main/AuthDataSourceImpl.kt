package pl.masslany.auth.data.network.main

import pl.masslany.auth.data.network.api.AuthApi
import pl.masslany.auth.data.network.models.AuthDto
import pl.masslany.auth.data.network.models.WykopConnectDto
import pl.masslany.business.auth.data.api.AuthDataSource
import pl.masslany.common.configstorage.api.ConfigStorage

class AuthDataSourceImpl(
    private val authApi: AuthApi,
    private val configStorage: ConfigStorage,
) : AuthDataSource {
    override suspend fun getAuthToken(): Result<AuthDto> {
        val key = configStorage.getApiKey()
        val secret = configStorage.getApiSecret()
        return authApi.getAuthToken(key, secret)
    }

    override suspend fun getWykopConnect(): Result<WykopConnectDto> {
        return authApi.getWykopConnect()
    }

    override suspend fun shouldUpdateTokens(): Boolean {
        val token = configStorage.getBearerToken()
        if (token.isEmpty()) {
            return true
        }

        return true
    }

    override suspend fun updateTokens(): Result<Unit> {
        val refreshToken = configStorage.getRefreshToken()
         if (refreshToken.isEmpty()) {
             return getAuthToken().mapCatching {
                configStorage.storeBearerToken(it.data.token)
                Result.success(Unit)
            }
        } else {
             return authApi.refreshTokens(refreshToken).mapCatching {
                configStorage.storeBearerToken(it.data.token)
                configStorage.storeRefreshToken(it.data.refreshToken)
                Result.success(Unit)
            }
        }
    }

    override suspend fun logout(): Result<Unit> {
        return authApi.logout().also {
            getAuthToken().mapCatching {
                configStorage.storeBearerToken(it.data.token)
                updateTokens()
            }
        }
    }

    internal companion object {
        const val JWT_EXPIRATION_LEEWAY_SECONDS = 60L
    }
}
