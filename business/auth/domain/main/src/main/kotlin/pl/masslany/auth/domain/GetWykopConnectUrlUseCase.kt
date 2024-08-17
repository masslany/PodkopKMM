package pl.masslany.auth.domain

interface GetWykopConnectUrlUseCase {
    suspend fun execute(): Result<String>
}

class GetWykopConnectUrlUseCaseImpl(
    private val authRepository: AuthRepository,
) : GetWykopConnectUrlUseCase {
    override suspend fun execute(): Result<String> {
        return authRepository.getWykopConnect()
    }
}
