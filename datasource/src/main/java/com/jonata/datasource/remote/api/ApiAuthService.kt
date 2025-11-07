package com.jonata.datasource.remote.api


import com.jonata.data.model.UserCredentialsData
import com.jonata.data.model.RefreshResponse
import com.jonata.data.model.TokenData
import com.jonata.data.model.request.RequestUpdateProfile
import com.jonata.data.model.response.ResponseUpdateProfile
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
        @Body body: UserCredentialsData
    ): TokenData

    @POST("v1/accounts:signUp")
    suspend fun signUp(
        @Query("key") apiKey: String,
        @Body body: UserCredentialsData
    ): TokenData


    @POST("v1/accounts:update")
    suspend fun updateProfile(
        @Query("key") apiKey: String,
        @Body body: RequestUpdateProfile
    ): ResponseUpdateProfile


    @FormUrlEncoded
    @POST("v1/token")
    suspend fun refreshToken(
        @Query("key") apiKey: String,
        @Field("grant_type") grantType: String = "refresh_token",
        @Field("refresh_token") refreshToken: String
    ): RefreshResponse


}