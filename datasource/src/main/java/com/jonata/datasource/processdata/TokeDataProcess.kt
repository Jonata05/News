package com.jonata.datasource.processdata

import com.jonata.data.model.TokenData
import kotlin.text.toLong

fun TokenData.processData(): TokenData{
    val defineExpireAt = (3600 * 1000) + System.currentTimeMillis()


    this.expiresAt = defineExpireAt
    return this
}