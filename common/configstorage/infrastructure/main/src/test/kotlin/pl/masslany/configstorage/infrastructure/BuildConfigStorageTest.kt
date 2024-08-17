package pl.masslany.configstorage.infrastructure

import pl.masslany.common.configstorage.infrastructure.BuildConfigStorage
import pl.masslany.persistence.api.KeyValueStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class BuildConfigStorageTest  {

    private val keyValueStorage = object : KeyValueStorage {
        val map = mutableMapOf<String, Any>()
        override suspend fun putString(key: String, value: String) {
            map[key] = value
        }

        override suspend fun getString(key: String): String? {
            return map[key] as String?
        }

        override suspend fun putBoolean(key: String, value: Boolean) {
            map[key] = value
        }

        override fun observeBoolean(key: String): Flow<Boolean> {
            return flowOf(map[key] as Boolean)
        }
    }


    private val sut = BuildConfigStorage(keyValueStorage)

    @Test
    fun `Given valid setup When inserting a key Then string is persisted`() = runTest {
        // Given
        val value = "value"

        // When
        sut.storeApiKey(value)

        // Then
        assertEquals(value, keyValueStorage.getString(KEY))
    }

    @Test
    fun `Given inserted value When getting a key Then string is returned`() = runTest {
        // Given
        val value = "value"
        sut.storeApiKey(value)

        // When
        val result = sut.getApiKey()

        // Then
        assertEquals(value, result)
    }

    @Test
    fun `Given valid setup When inserting a secret Then string is persisted`() = runTest {
        // Given
        val value = "value"

        // When
        sut.storeApiSecret(value)

        // Then
        assertEquals(value, keyValueStorage.getString(SECRET))
    }

    @Test
    fun `Given inserted value When getting a secter Then string is returned`() = runTest {
        // Given
        val value = "value"
        sut.storeApiSecret(value)

        // When
        val result = sut.getApiSecret()

        // Then
        assertEquals(value, result)
    }

    private companion object {
        const val KEY = "API_KEY"
        const val SECRET = "API_SECRET"
    }
}
