package pl.masslany.auth.data.network.main

import pl.masslany.auth.data.network.api.AuthApi
import pl.masslany.auth.data.network.models.AuthDto
import pl.masslany.auth.data.network.models.RefreshDto
import pl.masslany.auth.data.network.models.WykopConnectDto
import pl.masslany.common.configstorage.api.ConfigStorage
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AuthDataSourceImplTest {

    private val mockAuthApi = mockk<AuthApi>()
    private val mockConfigStorage = mockk<ConfigStorage>()

    private val sut = AuthDataSourceImpl(
        mockAuthApi,
        mockConfigStorage
    )

    @Test
    fun `Given key and secret When call getAuthToken Then return token`() = runTest {
        // Given
        val key = "key"
        val secret = "secret"
        val token = "token"
        val authDto = mockk<AuthDto> {
            every { data.token } returns token
        }
        coEvery { mockConfigStorage.getApiKey() } returns key
        coEvery { mockConfigStorage.getApiSecret() } returns secret
        coEvery { mockAuthApi.getAuthToken(key, secret) } returns Result.success(authDto)

        // When
        val result = sut.getAuthToken()

        // Then
        coVerify { mockAuthApi.getAuthToken(key, secret) }
        assertTrue(result.isSuccess)
        assertEquals(token, result.getOrNull()!!.data.token)
    }

    @Test
    fun `When call getWykopConnect Then call and return expected`() = runTest {
        // Given
        val wykopConnectDto = mockk<WykopConnectDto>()
        coEvery { mockAuthApi.getWykopConnect() } returns Result.success(wykopConnectDto)

        // When
        val result = sut.getWykopConnect()

        // Then
        coVerify { mockAuthApi.getWykopConnect() }
        assertTrue(result.isSuccess)
    }

    @Test
    fun `Given empty token When call shouldUpdateTokens Then return true`() = runTest {
        // Given
        val token = ""
        coEvery { mockConfigStorage.getBearerToken() } returns token

        // When
        val result = sut.shouldUpdateTokens()

        // Then
        coVerify { mockConfigStorage.getBearerToken() }
        assertTrue(result)
    }

    @Test
    fun `Given refreshToken is empty When call updateTokens Then call expected`() = runTest {
        // Given
        val refreshToken = ""
        val token = "token"
        val mockAuthDto = mockk<AuthDto> {
            every { data.token } returns token
        }
        val key = "key"
        val secret = "secret"
        coEvery { mockConfigStorage.getRefreshToken() } returns refreshToken
        coEvery { mockConfigStorage.getApiKey() } returns key
        coEvery { mockConfigStorage.getApiSecret() } returns secret
        coEvery { sut.getAuthToken() } returns Result.success(mockAuthDto)
        coEvery { mockAuthApi.getAuthToken(key, secret) } returns Result.success(mockAuthDto)
        coEvery { mockConfigStorage.storeBearerToken(token) } just Runs

        // When
        val result = sut.updateTokens()

        // Then
        coVerify { mockAuthApi.getAuthToken(key, secret) }
        assertTrue(result.isSuccess)
    }

    @Test
    fun `Given refreshToken When call updateTokens Then call expected`() = runTest {
        // Given
        val refreshToken = "refreshToken"
        val token = "token"
        val mockRefreshDto = mockk<RefreshDto> {
            every { data.token } returns token
            every { data.refreshToken } returns refreshToken
        }
        coEvery { mockConfigStorage.getRefreshToken() } returns refreshToken
        coEvery { mockAuthApi.refreshTokens(refreshToken) } returns Result.success(mockRefreshDto)
        coEvery { mockConfigStorage.storeBearerToken(token) } just Runs
        coEvery { mockConfigStorage.storeRefreshToken(refreshToken) } just Runs

        // When
        val result = sut.updateTokens()

        // Then
        coVerify { mockAuthApi.refreshTokens(refreshToken) }
        assertTrue(result.isSuccess)
    }

    @Test
    fun `When call logout Then call expected`() = runTest {
        // Given
        val refreshToken = "refreshToken"
        val token = "token"
        val mockAuthDto = mockk<AuthDto> {
            every { data.token } returns token
        }
        val key = "key"
        val secret = "secret"
        coEvery { mockConfigStorage.getRefreshToken() } returns refreshToken
        coEvery { mockConfigStorage.getApiKey() } returns key
        coEvery { mockConfigStorage.getApiSecret() } returns secret
        coEvery { mockAuthApi.getAuthToken(key, secret) } returns Result.success(mockAuthDto)
        coEvery { mockAuthApi.logout() } returns mockk()
        coEvery { mockConfigStorage.getRefreshToken() } returns refreshToken
        coEvery { mockConfigStorage.storeBearerToken(token) } just Runs

        // When
        val result = sut.logout()

        // Then
        coVerify { mockAuthApi.logout() }
        assertTrue(result.isSuccess)
    }
}
