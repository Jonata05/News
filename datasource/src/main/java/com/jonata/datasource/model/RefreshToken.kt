package com.jonata.datasource.model

data class RefreshTokenResponseDTO(
    val access_token: String,
    val expires_in: String,
    val refresh_token: String,
    val user_id: String,
    val project_id: String
){



}
