package com.jonata.data.repository

import android.util.Log
import com.jonata.data.datasource.AuthLocalDataSource
import com.jonata.data.datasource.AuthRemoteDataSource
import com.jonata.data.mapper.toData
import com.jonata.data.mapper.toDomain
import com.jonata.data.model.RefreshResponse
import com.jonata.data.model.request.RequestUpdateProfile
import com.jonata.data.model.updateIdToke
import com.jonata.domain.model.Token
import com.jonata.domain.model.UserCredentials
import com.jonata.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remote: AuthRemoteDataSource,
    private val local: AuthLocalDataSource
): AuthRepository {


    override suspend fun signIn(userCredentials: UserCredentials) {
        val tokenData =  remote.signIn(userCredentials.toData())
        local.saveToken(tokenData)
    }


    override suspend fun signUp(userCredentials: UserCredentials) {
        val tokenData =  remote.signUp(userCredentials.toData())

        val requestUpdateProfile = RequestUpdateProfile(
            idToken = tokenData.idToken,
            displayName = "Jonata Ferreira")

        val resultProfileUpdated = updateProfile(requestUpdateProfile)

        tokenData.displayName = resultProfileUpdated.displayName

        local.saveToken(tokenData)
    }


    override fun logout() = local.clearToken()


    override fun isLoggedIn(): Boolean = local.isLoggedIn()


    override suspend fun getToken(): Token = getTokenValidate()

    suspend fun getTokenValidate(): Token {
        val currentToken = local.getToken().toDomain()
        val tokenRefresh = currentToken.getTokenRefresh()
        if (currentToken.isValid()) return currentToken

        updateToken(currentToken,tokenRefresh)
        val newToken = local.getToken().toDomain()
        return newToken
    }


    private suspend fun updateToken(token:Token, tokenRefresh: String){
        val response: RefreshResponse = remote.updateToken(tokenRefresh)
        val newToken = token.updateIdToke(response)
        local.saveToken(newToken.toData())
    }


    suspend fun updateProfile(requestUpdateProfile: RequestUpdateProfile)=
        remote.updateProfile(requestUpdateProfile)


}