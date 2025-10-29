package com.jonata.datasource.api.auth

import com.jonata.datasource.model.RefreshRequest
import com.jonata.datasource.model.TokenResponse
import com.jonata.domain.model.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiAuthService {



    // Exemplo de login inicial
    @POST("identitytoolkit/v1/accounts:signInWithPassword?")
    suspend fun login(
        @Query("key") apiKey: String,
        @Body body: LoginRequest
    ): TokenResponse

    // 🔹 Endpoint para atualizar o token
    @POST("auth/refresh")
    suspend fun refreshToken(
        @Body body: RefreshRequest
    ): TokenResponse

}