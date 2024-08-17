package pl.masslany.auth.domain

interface AuthRepository {

    suspend fun getWykopConnect(): Result<String>

    suspend fun shouldUpdateTokens(): Boolean

    suspend fun updateTokens(): Result<Unit>

    suspend fun logout(): Result<Unit>
}
