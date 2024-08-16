package pl.masslany.auth.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshDto(
    @SerialName("data")
    val data: RefreshResponseData,
)

@Serializable
data class RefreshResponseData(
    @SerialName("refresh_token")
    val refreshToken: String,
    @SerialName("token")
    val token: String,
)
