package pl.masslany.network.models.request

data class Request<T>(
    val method: HttpMethod,
    val path: String,
    val headers: Map<String, String>? = null,
    val queryParameters: Map<String, String>? = null,
    @JvmField
    var body: Any? = null,
) {
    enum class HttpMethod {
        GET,
        DELETE,
        PATCH,
        POST,
        PUT,
    }
}
