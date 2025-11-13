package com.jonata.data.datasource

import com.jonata.data.model.UserCredentialsData
import com.jonata.data.model.RefreshResponse
import com.jonata.data.model.TokenData
import com.jonata.data.model.request.RequestUpdateProfile
import com.jonata.data.model.response.ResponseUpdateProfile

interface AuthRemoteDataSource {

    suspend fun signIn(userCredentials: UserCredentialsData): TokenData

    suspend fun signUp(userCredentials: UserCredentialsData): TokenData

    suspend fun updateToken(refreshToken: String): RefreshResponse

    suspend fun updateProfile(requestUpdateProfile: RequestUpdateProfile):ResponseUpdateProfile
}