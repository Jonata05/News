package com.jonata.data.model

data class TokenData(
    val localId: String,
    val email: String,
    var displayName: String,
    val idToken: String,
    val registered: Boolean,
    val refreshToken: String,
    var expiresAt: Long,
)