package com.jonata.domain.repository

import com.jonata.domain.model.TokenResponse
import com.jonata.domain.result.ResultTask

interface AuthRepository {
      suspend fun login(email: String, password: String,) : ResultTask<Unit>
}