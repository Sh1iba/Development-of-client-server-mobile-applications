package com.example.register

import kotlinx.serialization.Serializable

@Serializable
data class RegisterReceiveRemote(
    val login: String,
    val password: String,
    val email: String
)

val emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
fun isValidEmail(email: String): Boolean {
    return email.matches(emailRegex.toRegex())
}

@Serializable
data class RegisterResponseRemote(
    val token: String
)