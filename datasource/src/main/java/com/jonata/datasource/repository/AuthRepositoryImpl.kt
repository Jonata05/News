package com.jonata.datasource.repository


import com.jonata.datasource.api.auth.ApiAuthService
import com.jonata.datasource.model.login.toLoginRequest
import com.jonata.datasource.model.token.RefreshRequest
import com.jonata.datasource.model.token.TokenResponse
import com.jonata.domain.model.Token
import com.jonata.domain.model.UserCredentials
import com.jonata.domain.repository.AuthRepository
import javax.inject.Inject



class AuthRepositoryImpl @Inject constructor(
    private val apiAuthService: ApiAuthService,
): AuthRepository {


    override suspend fun login(userCredentials: UserCredentials) : Token {

        val key = "AIzaSyA18DTqqQYujRehCDUjay2SC-i47U8V8gw"
        val url = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=$key"

        val request =userCredentials.toLoginRequest()
        val response : TokenResponse = apiAuthService.login(url, request)

        return response.toToken()
    }


//    override suspend fun updateIdToken(refreshToken: String) : Token{
//
//        val request = RefreshRequest(refreshToken)
//        val response = apiAuthService.refreshToken(request)
//        response.toToken()
//
//        return TokenResponse("","","","",true,"",0L)
//    }



}

