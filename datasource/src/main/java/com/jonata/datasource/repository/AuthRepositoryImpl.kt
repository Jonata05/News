package com.jonata.datasource.repository


import com.jonata.datasource.api.auth.ApiAuthService
import com.jonata.datasource.api.TokenManager
import com.jonata.datasource.model.RefreshRequest
import com.jonata.datasource.model.TokenResponse
import com.jonata.domain.RunTask
import com.jonata.domain.model.LoginRequest
import com.jonata.domain.repository.AuthRepository
import com.jonata.domain.result.ResultTask
import javax.inject.Inject
import javax.inject.Named
import kotlin.math.exp

class AuthRepositoryImpl @Inject constructor(
    private val apiAuthService: ApiAuthService,
    private val tokenManager: TokenManager,
): AuthRepository {


    override suspend fun login(email: String, password: String): ResultTask<Unit> {

        val request = LoginRequest(
            email = "jntferreiratj@hotmail.com",
            password = "jntferreiratj@hotmail.com",
            username = ""
        )

        val key = ""

        val response = apiAuthService.login(key, request)


        tokenManager.saveTokens(
            idToken = response.idToken,
            refreshToken = response.refreshToken,
            expiresIn = response.expiresIn,
            localId = response.localId
        )

        return ResultTask.success(Unit)


    }


    suspend fun updateIdToken(refreshToken: String) : ResultTask<Unit>{

        val request = RefreshRequest(refreshToken)


        val response = apiAuthService.refreshToken(request)


            tokenManager.saveTokens(
                idToken = response.idToken,
                refreshToken = response.refreshToken,
                expiresIn = response.expiresIn,
                localId = response.localId
            )

            return ResultTask.success(Unit)
    }

    suspend fun cleanTokenManager() : Result<Unit>{

        tokenManager.cleanTokenManager()

        return Result.success(Unit)
    }

    suspend fun loggedInUser(): Result<Boolean>{

        val result = tokenManager.tokenIdIsNull()

       return Result.success(result)
    }








}