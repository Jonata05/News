package com.jonata.data.model.request

data class RequestUpdateProfile (
    val idToken: String,
    val displayName: String? = null,
    val photoUrl:String? = null,
    val deleteAttribute: List<String>? =null,
    val returnSecureToken: Boolean = true
)