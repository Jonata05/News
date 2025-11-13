package com.jonata.data.model

import com.jonata.domain.model.UserCredentials
import com.jonata.domain.model.Email
import com.jonata.domain.model.Password

data class UserCredentialsData(
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)

