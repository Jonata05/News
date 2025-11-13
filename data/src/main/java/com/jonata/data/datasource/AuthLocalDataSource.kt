package com.jonata.data.datasource

import com.jonata.data.model.TokenData

interface AuthLocalDataSource {

    fun saveToken(token: TokenData)

    fun getToken(): TokenData

    fun clearToken()

    fun isLoggedIn(): Boolean
}