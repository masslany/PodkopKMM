package pl.masslany.business.common.data.network.models.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RankDto(
    @SerialName("position")
    val position: Int?,
    @SerialName("trend")
    val trend: Int,
)
