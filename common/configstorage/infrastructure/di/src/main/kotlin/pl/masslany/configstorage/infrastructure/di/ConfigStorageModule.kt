package pl.masslany.configstorage.infrastructure.di

import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton
import pl.masslany.common.configstorage.api.ConfigStorage
import pl.masslany.common.configstorage.infrastructure.BuildConfigStorage
import pl.masslany.persistence.api.KeyValueStorage
import pl.masslany.persistence.infrastructure.di.DataStoreModule

@Module(includes = [DataStoreModule::class])
class ConfigStorageModule {

    @Singleton
    fun provideConfigStorage(
        keyValueStorage: KeyValueStorage
    ): ConfigStorage {
        return BuildConfigStorage(
            keyValueStorage
        )
    }
}
