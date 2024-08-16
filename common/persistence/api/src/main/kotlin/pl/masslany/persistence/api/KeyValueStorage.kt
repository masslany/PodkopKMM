package pl.masslany.persistence.api

import kotlinx.coroutines.flow.Flow

interface KeyValueStorage {
    suspend fun putString(
        key: String,
        value: String,
    )

    suspend fun getString(key: String): String?

    suspend fun putBoolean(
        key: String,
        value: Boolean,
    )

    fun observeBoolean(key: String): Flow<Boolean?>
}
