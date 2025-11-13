package com.jonata.domain.model

import android.util.Log
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.inject.Inject


class ExpireInDomain @Inject constructor(private val value: Long) {





    fun getLabel(): String {
        val dateTime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(value),
            ZoneId.systemDefault()
        )

        val formatter = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.getDefault())
        val dateFormate = dateTime.format(formatter)
        return dateFormate
    }

    fun get(): Long = value


    fun isUpdated(): Boolean {
        val currentMillis = System.currentTimeMillis()
        return value > currentMillis
    }

}

