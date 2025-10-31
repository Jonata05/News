package com.jonata.domain.repository

import com.jonata.domain.model.Token
import com.jonata.domain.model.UserCredentials
import kotlinx.coroutines.flow.StateFlow

interface AuthRepository {
      suspend fun login(userCredentials: UserCredentials): Token

//    suspend fun updateIdToken(refreshToken: String): Token


}