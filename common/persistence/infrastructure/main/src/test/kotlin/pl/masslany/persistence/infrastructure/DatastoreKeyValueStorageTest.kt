package pl.masslany.persistence.infrastructure

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStoreFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class DatastoreKeyValueStorageTest  {
    private lateinit var testDataStore: DataStore<Preferences>
    private lateinit var sut: DatastoreKeyValueStorage

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        val context = RuntimeEnvironment.getApplication()
        testDataStore = PreferenceDataStoreFactory.create(
            scope = TestScope(),
            produceFile = { context.preferencesDataStoreFile("pl.masslany.datastore.test") }
        )

        sut = DatastoreKeyValueStorage(testDataStore)
    }

    @Test
    fun `Given valid setup When inserting a string Then string is persisted`() = runTest {
        // Given
        val key = "key"
        val value = "value"

        // When
        sut.putString(key, value)

        // Then
        assertEquals(value, testDataStore.data.firstOrNull()?.get(stringPreferencesKey(key)))
    }

    @Test
    fun `Given inserted value When getting a string Then string is returned`() = runTest {
        // Given
        val key = "key"
        val value = "value"
        sut.putString(key, value)

        // When
        val result = sut.getString(key)

        // Then
        assertEquals(value, result)
    }
}
