package pl.masslany.business.common.domain.models.common

data class Answer(
    val count: Int,
    val id: Int,
    val text: String,
    val voted: Int,
)
