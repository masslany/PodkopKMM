package pl.masslany.network.infrastructure

import io.ktor.client.plugins.logging.Logger

class AndroidLogger : Logger {
    override fun log(message: String) {
        message.chunked(4095).forEach { chunkedMessage ->
            println("AndroidLogger: $chunkedMessage")
        }
    }
}
