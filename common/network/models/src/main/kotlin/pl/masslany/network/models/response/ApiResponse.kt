package pl.masslany.network.models.response

data class ApiResponse<T>(
    val content: T,
)
