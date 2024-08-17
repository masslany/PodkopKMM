package pl.masslany.business.auth.data.main

import pl.masslany.auth.domain.AuthRepository
import pl.masslany.business.auth.data.api.AuthDataSource

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource,
) : AuthRepository {

    override suspend fun getWykopConnect(): Result<String> {
        return authDataSource.getWykopConnect().mapCatching { it.data.connectUrl }
    }

    override suspend fun shouldUpdateTokens(): Boolean {
        return authDataSource.shouldUpdateTokens()
    }

    override suspend fun updateTokens(): Result<Unit> {
        return authDataSource.updateTokens()
    }

    override suspend fun logout(): Result<Unit> {
        return authDataSource.logout()
    }
}
