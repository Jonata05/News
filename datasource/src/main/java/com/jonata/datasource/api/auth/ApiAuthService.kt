package com.jonata.datasource.api.auth

import com.jonata.datasource.model.login.CredentialsRequest
import com.jonata.datasource.model.token.RefreshResponse
import com.jonata.datasource.model.token.TokenResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiAuthService {



    @POST
    suspend fun login(
        @Url url: String,
        @Body body: CredentialsRequest
    ): TokenResponse

    @POST("v1/accounts:signUp")
    suspend fun signUp(
        @Query("key") apiKey: String,
        @Body body: CredentialsRequest
    ): TokenResponse


    @FormUrlEncoded
    @POST("v1/token")
    suspend fun refreshToken(
        @Query("key") apiKey: String,
        @Field("grant_type") grantType: String = "refresh_token",
        @Field("refresh_token") refreshToken: String
    ): RefreshResponse


}