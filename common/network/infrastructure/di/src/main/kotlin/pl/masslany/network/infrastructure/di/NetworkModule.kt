package pl.masslany.network.infrastructure.di

import pl.masslany.common.configstorage.api.ConfigStorage
import pl.masslany.network.api.ApiClient
import pl.masslany.network.api.RefreshTokensEventReducer
import pl.masslany.network.infrastructure.HttpClientFactory
import pl.masslany.network.infrastructure.ApiClientImpl
import pl.masslany.network.infrastructure.RefreshTokensEventReducerImpl
import pl.masslany.network.infrastructure.mapper.RequestToKtorRequestBuilderMapper
import io.ktor.client.HttpClient
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton
import pl.masslany.configstorage.infrastructure.di.ConfigStorageModule


@Module(includes = [ConfigStorageModule::class])
class NetworkModule {

    @Singleton
    fun provideHttpClient(
        configStorage: ConfigStorage,
        refreshTokensEventReducer: RefreshTokensEventReducer,
    ): HttpClient {
        return HttpClientFactory(
            configStorage,
            refreshTokensEventReducer,
        ).create()
    }

    @Singleton
    fun provideRequestToKtorRequestBuilderMapper(): RequestToKtorRequestBuilderMapper {
        return RequestToKtorRequestBuilderMapper()
    }

    @Singleton
    fun provideNetworkClient(
        httpClient: HttpClient,
        requestMapper: RequestToKtorRequestBuilderMapper,
    ): ApiClient {
        return ApiClientImpl(
            httpClient = httpClient,
            requestToKtorRequestBuilderMapper = requestMapper,
        )
    }

    @Singleton
    fun provideRefreshTokensEventReducer(): RefreshTokensEventReducer {
        return RefreshTokensEventReducerImpl()
    }

}
