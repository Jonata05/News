package com.jonata.data.model

import com.google.gson.annotations.SerializedName
import com.jonata.domain.model.Email
import com.jonata.domain.model.ExpireInDomain
import com.jonata.domain.model.Name
import com.jonata.domain.model.Token

data class RefreshResponse(
    @SerializedName("id_token") val idToken: String,
    @SerializedName("refresh_token") val refreshToken: String,
    @SerializedName("expires_in") var expiresIn: String,
    var expiresAt: Long

)


fun Token.updateIdToke(refreshResponse: RefreshResponse) : Token{

    val name= Name(this.getName())
    val email = Email(this.getEmail())
    val localId = this.getLocalId()


   return Token(tokenRefresh = refreshResponse.refreshToken,
        idToken = refreshResponse.idToken,
        expiresAt = ExpireInDomain(refreshResponse.expiresAt) ,
        displayName = name,
        email = email,
        localId = localId)
    
}