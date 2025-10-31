package com.jonata.datasource.api.auth

import com.jonata.datasource.model.login.LoginRequest
import com.jonata.datasource.model.token.RefreshRequest
import com.jonata.datasource.model.token.TokenResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiAuthService {



    @POST
    suspend fun login(
        @Url url: String,
        @Body body: LoginRequest
    ): TokenResponse

//    // 🔹 Endpoint para atualizar o token
//    @POST("auth/refresh")
//    suspend fun refreshToken(
//        @Body body: RefreshRequest
//    ): TokenResponse

}