package pl.masslany.auth.domain

interface ShouldUpdateTokensUseCase {
    suspend fun execute(): Boolean
}

class ShouldUpdateTokensUseCaseImpl(
    private val authRepository: AuthRepository,
) : ShouldUpdateTokensUseCase {
    override suspend fun execute(): Boolean {
        return authRepository.shouldUpdateTokens()
    }
}
