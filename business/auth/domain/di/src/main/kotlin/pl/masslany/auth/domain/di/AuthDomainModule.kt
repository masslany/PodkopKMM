package pl.masslany.auth.domain.di

import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import pl.masslany.auth.data.infrastructure.di.AuthDataModule
import pl.masslany.auth.domain.AuthRepository
import pl.masslany.auth.domain.GetWykopConnectUrlUseCase
import pl.masslany.auth.domain.GetWykopConnectUrlUseCaseImpl
import pl.masslany.auth.domain.LogoutUseCase
import pl.masslany.auth.domain.LogoutUseCaseImpl
import pl.masslany.auth.domain.ShouldUpdateTokensUseCase
import pl.masslany.auth.domain.ShouldUpdateTokensUseCaseImpl
import pl.masslany.auth.domain.UpdateTokensUseCase
import pl.masslany.auth.domain.UpdateTokensUseCaseImpl

@Module(includes = [AuthDataModule::class])
class AuthDomainModule {

    @Factory
    fun provideGetWykopConnectUrlUseCase(
        authRepository: AuthRepository
    ): GetWykopConnectUrlUseCase {
        return GetWykopConnectUrlUseCaseImpl(authRepository)
    }

    @Factory
    fun provideUpdateTokensUseCase(
        authRepository: AuthRepository
    ): UpdateTokensUseCase {
        return UpdateTokensUseCaseImpl(authRepository)
    }

    @Factory
    fun provideLogoutTokensUseCase(
        authRepository: AuthRepository
    ): LogoutUseCase {
        return LogoutUseCaseImpl(authRepository)
    }

    @Factory
    fun provideShouldUpdateTokensUseCase(
        authRepository: AuthRepository
    ): ShouldUpdateTokensUseCase {
        return ShouldUpdateTokensUseCaseImpl(authRepository)
    }
}
