package com.jonata.data.mapper


import com.jonata.data.model.TokenData
import com.jonata.domain.model.Email
import com.jonata.domain.model.ExpireInDomain
import com.jonata.domain.model.Name
import com.jonata.domain.model.Token


fun Token.toData(): TokenData {
        return TokenData(
            localId = this.getLocalId(),
            email = this.getEmail(),
            displayName =this.getName(),
            idToken = this.getIdToken(),
            registered = this.getRegistered(),
            refreshToken = this.getTokenRefresh(),
            expiresAt = this.getExpiresIn()

        )

}


fun TokenData.toDomain()=
    Token(
        localId = this.localId,
        email = Email(this.email),
        displayName = Name(this.displayName),
        idToken = this.idToken,
        registered = this.registered,
        tokenRefresh = this.refreshToken,
        expiresAt = ExpireInDomain(this.expiresAt)
    )

