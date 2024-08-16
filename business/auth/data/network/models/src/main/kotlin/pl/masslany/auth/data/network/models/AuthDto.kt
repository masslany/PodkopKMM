package pl.masslany.auth.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthDto(
    @SerialName("data")
    val data: AuthDtoData,
)

@Serializable
data class AuthDtoData(val token: String)
