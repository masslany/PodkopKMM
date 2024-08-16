package pl.masslany.auth.domain

interface LogoutUseCase {
    suspend fun execute(): Result<Unit>
}

class LogoutUseCaseImpl(
    private val authRepository: AuthRepository,
) : LogoutUseCase {
    override suspend fun execute(): Result<Unit> {
        return authRepository.logout()
    }
}
