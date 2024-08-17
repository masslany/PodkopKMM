package pl.masslany.auth.domain

interface UpdateTokensUseCase {
    suspend fun execute(): Result<Unit>
}

class UpdateTokensUseCaseImpl(
    private val authRepository: AuthRepository,
) : UpdateTokensUseCase {
    override suspend fun execute(): Result<Unit> {
        return authRepository.updateTokens()
    }
}
