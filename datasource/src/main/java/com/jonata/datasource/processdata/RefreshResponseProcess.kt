package com.jonata.datasource.processdata

import com.jonata.data.model.RefreshResponse

fun RefreshResponse.processData(): RefreshResponse{
    val defineExpireAt = (3600 * 1000) + System.currentTimeMillis()


    this.expiresAt = defineExpireAt
    return this
}