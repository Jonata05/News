package com.jonata.domain.model

import java.time.LocalDateTime

data class TokenResponse (
    private var idToken: String?,
    private var refreshToken: String?,
    private var expiresIn: LocalDateTime?,
    private var localId: String?
){



    fun setExpiresIn(expiresIn: Long){
       this.expiresIn =  LocalDateTime.now().plusSeconds(expiresIn)
    }


}