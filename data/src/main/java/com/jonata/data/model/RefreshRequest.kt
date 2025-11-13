package com.jonata.data.model

data class RefreshRequest(
    val grantType : String = "refresh_token",
    val refreshToken: String
)