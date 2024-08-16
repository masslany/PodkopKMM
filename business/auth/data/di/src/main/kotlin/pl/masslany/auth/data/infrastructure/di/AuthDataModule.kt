package pl.masslany.auth.data.infrastructure.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import pl.masslany.auth.data.infrastructure.network.di.AuthNetworkModule
import pl.masslany.auth.domain.AuthRepository
import pl.masslany.business.auth.data.api.AuthDataSource
import pl.masslany.business.auth.data.main.AuthRepositoryImpl

@Module(includes = [AuthNetworkModule::class])
@ComponentScan
class AuthDataModule {

    @Factory
    fun provideAuthRepository(
        authDataSource: AuthDataSource
    ): AuthRepository {
        return AuthRepositoryImpl(
            authDataSource
        )
    }
}
