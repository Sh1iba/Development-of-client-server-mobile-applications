package com.example.register

import com.example.database.tokens.TokenDTO
import com.example.database.tokens.Tokens
import com.example.database.users.UserDTO
import com.example.database.users.Users
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import org.jetbrains.exposed.exceptions.ExposedSQLException
import java.util.UUID

class RegisterController(private val call: ApplicationCall) {
    suspend fun registerNewUser(){
        try {
            val registerReceiveRemote = call.receive<RegisterReceiveRemote>()
            if (!registerReceiveRemote.email.isValidEmail()) {
                call.respond(HttpStatusCode.BadRequest, "Email is not valid")
                return
            }
            val userDTO = Users.fetchUser(registerReceiveRemote.login)

            if (userDTO != null) {
                call.respond(HttpStatusCode.Conflict, "User already exists")
                return
            }

            val token = UUID.randomUUID().toString()
            try {
                Users.insert(
                    UserDTO(
                        login = registerReceiveRemote.login,
                        password = registerReceiveRemote.password,
                        email = registerReceiveRemote.email,
                        username = ""
                    )
                )

                Tokens.insert(
                    TokenDTO(
                        id = UUID.randomUUID().toString(),
                        login = registerReceiveRemote.login,
                        token = token
                    )
                )
                call.respond(HttpStatusCode.Created, message = RegisterResponseRemote(token = token))

            } catch (e: ExposedSQLException) {
                // Логируем ошибку для диагностики
                println("Database error: ${e.message}")
                call.respond(
                    HttpStatusCode.InternalServerError,
                    "Registration failed. Please try again."
                )
            }
        } catch (e: ContentTransformationException) {
            call.respond(HttpStatusCode.BadRequest, "Invalid request format")
        } catch (e: Exception) {
            println("Unexpected error: ${e.stackTraceToString()}")
            call.respond(
                HttpStatusCode.InternalServerError,
                "An unexpected error occurred"
            )
        }

    }
}

