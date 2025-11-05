package com.jonata.domain.repository

import com.jonata.domain.model.Token
import com.jonata.domain.model.UserCredentials

interface AuthRepository {
      suspend fun signIn(userCredentials: UserCredentials)

      suspend fun signUp(userCredentials: UserCredentials)

      fun logout()

      fun isLoggedIn() : Boolean

      suspend fun getToken(): Token


}