package com.example.register

import kotlinx.serialization.Serializable

@Serializable
data class RegisterReceiveRemote(
    val login: String,
    val password: String,
    val email: String
)

private const val EMAIL_REGEX = """[a-zA-Z0-9\+\.\_\%\-\+]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\-]{0,64}(\.[a-zA-Z0-9][a-zA-Z0-9\-]{0,25})+"""

fun String.isValidEmail(): Boolean {

    if (this.isBlank()) return false
    if (this.length > 254) return false
    val pattern = Regex(EMAIL_REGEX)
    if (!this.matches(pattern)) return false
    if (this.substringAfterLast('@').contains("..")) return false
    if (this.startsWith(".") || this.endsWith(".")) return false
    return true
}

@Serializable
data class RegisterResponseRemote(
    val token: String
)