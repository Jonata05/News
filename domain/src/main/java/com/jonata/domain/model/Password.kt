package com.jonata.domain.model

class Password(private val value: String) {

    init {
        require(value.isNotBlank()) { "password_is_empty" }
        require(isValidPassword(value)) { "password_invalidated" }
    }

    fun get(): String = value

    companion object {
        private val PASSWORD_REGEX = Regex("^(?=.*[A-Za-z])(?=.*\\d).{8,}$")
        // Explicação:
        // (?=.*[A-Za-z]) -> pelo menos uma letra
        // (?=.*\\d) -> pelo menos um número
        // .{8,} -> pelo menos 8 caracteres

        fun isValidPassword(password: String): Boolean {
            return PASSWORD_REGEX.matches(password)
        }
    }
}