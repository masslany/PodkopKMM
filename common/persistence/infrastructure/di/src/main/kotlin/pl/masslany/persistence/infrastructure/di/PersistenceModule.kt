package pl.masslany.persistence.infrastructure.di

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import okio.Path.Companion.toPath
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton
import pl.masslany.persistence.api.KeyValueStorage
import pl.masslany.persistence.infrastructure.DatastoreKeyValueStorage

const val DATASTORE_NAME = "podkop.preferences_pb"

@Module
@ComponentScan
class DataStoreModule {

    @Singleton
    fun provideDatastoreStorage(): KeyValueStorage {
        val datastore = PreferenceDataStoreFactory.createWithPath {
            DATASTORE_NAME.toPath()
        }

        return DatastoreKeyValueStorage(datastore)
    }
}
