package com.jonata.datasource.remote


import com.jonata.data.datasource.AuthRemoteDataSource
import com.jonata.data.model.UserCredentialsData
import com.jonata.data.model.RefreshResponse
import com.jonata.data.model.TokenData
import com.jonata.data.model.request.RequestUpdateProfile
import com.jonata.data.model.response.ResponseUpdateProfile
import com.jonata.datasource.processdata.processData
import com.jonata.datasource.remote.api.ApiAuthService
import jakarta.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val apiAuthService: ApiAuthService,
): AuthRemoteDataSource {

    val apiKey = "AIzaSyA18DTqqQYujRehCDUjay2SC-i47U8V8gw"


     override suspend fun signIn(userCredentials: UserCredentialsData) : TokenData {
        val url = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=$apiKey"

         return apiAuthService.login(url, userCredentials).processData()
    }


    override suspend fun signUp(userCredentials: UserCredentialsData): TokenData =
        apiAuthService.signUp(apiKey, userCredentials).processData()




    override suspend fun updateToken(refreshToken: String): RefreshResponse =
        apiAuthService.refreshToken(apiKey, refreshToken =  refreshToken).processData()


    override suspend fun updateProfile(requestUpdateProfile: RequestUpdateProfile): ResponseUpdateProfile =
        apiAuthService.updateProfile( apiKey,requestUpdateProfile)


}