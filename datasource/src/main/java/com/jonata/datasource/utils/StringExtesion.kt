package com.jonata.datasource.utils

import java.time.LocalDate
import java.time.LocalDateTime

fun String.toLocalDateTime() : LocalDateTime {

    val result = LocalDateTime.parse(this)
    return result
}
