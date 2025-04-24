package com.example

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class Test(val text: String)

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respond(Test("Hello world from class Test"))
        }
    }
}
