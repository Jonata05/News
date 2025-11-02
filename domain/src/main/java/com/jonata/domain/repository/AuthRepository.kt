package com.jonata.domain.repository

import com.jonata.domain.model.Token
import com.jonata.domain.model.UserCredentials

interface AuthRepository {
      suspend fun signIn(userCredentials: UserCredentials): Token

      suspend fun signUp(userCredentials: UserCredentials): Token


}