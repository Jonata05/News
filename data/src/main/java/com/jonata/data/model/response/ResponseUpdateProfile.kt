package com.jonata.data.model.response


data class ResponseUpdateProfile (
    val localId: String,
    val email: String,
    val displayName: String,
    val photoUrl: String,
    val idToken: String,
    val refreshToken: String,
    val expiresIn: String
)