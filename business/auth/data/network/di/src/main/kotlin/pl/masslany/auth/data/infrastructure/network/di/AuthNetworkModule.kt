package pl.masslany.auth.data.infrastructure.network.di

import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import pl.masslany.auth.data.infrastructure.network.client.AuthApiClient
import pl.masslany.auth.data.network.api.AuthApi
import pl.masslany.auth.data.network.main.AuthDataSourceImpl
import pl.masslany.business.auth.data.api.AuthDataSource
import pl.masslany.common.configstorage.api.ConfigStorage
import pl.masslany.network.api.ApiClient
import pl.masslany.network.infrastructure.di.NetworkModule

@Module(includes = [NetworkModule::class])
class AuthNetworkModule {

    @Factory
    fun provideAuthApi(
        apiClient: ApiClient
    ): AuthApi {
        return AuthApiClient(apiClient)
    }

    @Factory
    fun provideAuthDataSource(
        authApi: AuthApi,
        configStorage: ConfigStorage,
    ): AuthDataSource {
        return AuthDataSourceImpl(
            authApi,
            configStorage
        )
    }
}
