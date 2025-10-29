package com.jonata.datasource.model

data class LoginRequest(
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)

data class TokenResponse(
    val idToken: String,
    val refreshToken: String,
    val expiresIn: String,
    val localId: String
)

data class RefreshRequest(
    val refreshToken: String
)