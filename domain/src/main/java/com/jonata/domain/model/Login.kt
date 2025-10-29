package com.jonata.domain.model

// Request
data class LoginRequest(
    val username: String,
    val email: String,
    val password: String
)

// Response
data class LoginResponse(
    val token: String
)
