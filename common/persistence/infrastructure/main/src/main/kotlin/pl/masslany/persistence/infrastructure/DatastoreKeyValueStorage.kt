package pl.masslany.persistence.infrastructure

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import pl.masslany.persistence.api.KeyValueStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class DatastoreKeyValueStorage(
    private val dataStore: DataStore<Preferences>
) : KeyValueStorage {
    override suspend fun putString(key: String, value: String) {
        dataStore.edit { preferences ->
            preferences[stringPreferencesKey(key)] = value
        }
    }

    override suspend fun getString(key: String): String? {
        return dataStore.data.firstOrNull()?.get(stringPreferencesKey(key))
    }

    override suspend fun putBoolean(key: String, value: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value
        }
    }

    override fun observeBoolean(key: String): Flow<Boolean?> {
        return dataStore.data.map { preferences ->
            preferences[booleanPreferencesKey(key)]
        }
    }
}
