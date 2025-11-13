package com.jonata.domain.model

data class UserCredentials(
    val email: Email,
    val password: Password,
) {
    init {
        require(password.get() != email.get()) { "Senha não pode ser igual ao email" }
    }
}


