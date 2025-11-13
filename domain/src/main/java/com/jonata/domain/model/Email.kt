package com.jonata.domain.model

class Email(private val value: String) {

    init {
        require(value.isNotBlank()) { "Email não pode ser vazio" }
        require(isValidEmail(value)) { "Email inválido" }
    }

    fun get(): String = value.trim()

    fun item(): String = value.trim()


    companion object {
        private val EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()

        fun isValidEmail(email: String): Boolean {
            return EMAIL_REGEX.matches(email.trim())
        }
    }
}