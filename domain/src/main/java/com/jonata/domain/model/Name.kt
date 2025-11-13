package com.jonata.domain.model

class Name(private val value: String) {

    val first
        get()= value.trim().split(Regex("\\s+")).firstOrNull().orEmpty()

    val last
        get()= value.trim().split(Regex("\\s+")).lastOrNull().orEmpty()

    val full
        get() = value


    init {
//        require(value.isNotBlank()) { "O nome não pode ser vazio." }

        val invalids = listOf("dos", "das", "do", "da")

        require(!value.any { it.isDigit() }) { "O nome não pode conter números." }


        require(first.lowercase() !in invalids && last.lowercase() !in invalids) {
            "O nome não pode começar ou terminar com 'dos' ou 'das'."
        }

    }


}

