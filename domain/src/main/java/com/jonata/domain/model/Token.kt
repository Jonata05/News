package com.jonata.domain.model

import javax.inject.Inject


class Token @Inject constructor (
    private var idToken: String,
    private var expiresAt: ExpireInDomain,
    private var tokenRefresh:String,
    private val displayName: Name,
    private val email: Email,
    private val registered : Boolean = true,
    private val localId: String,
    private val tokenType: String  = "Bearer",

) {


    fun isValid(): Boolean  = (expiresAt).isUpdated()


    fun getRegistered() : Boolean = registered

    fun getLocalId(): String = localId

    fun getEmail() : String = email.get()

    fun getName(): String = displayName.full

    fun getIdToken(): String = idToken

    fun getExpiresIn() : Long = expiresAt.get()

    fun getTokenRefresh(): String = tokenRefresh

    fun getExpiresInString(): String = expiresAt.getLabel()





}