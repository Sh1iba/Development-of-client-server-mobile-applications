package com.example

import com.example.login.configureLoginRouting
import com.example.register.configureRegisterRouting
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>) {
    io.ktor.server.cio.EngineMain.main(args)
}

fun Application.module() {

    Database.connect(
        url = "jdbc:postgresql://localhost:5432/users",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "gantel007"
    )
    configureSerialization()
    configureRouting()
    configureRegisterRouting()
    configureLoginRouting()
}
