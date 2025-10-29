package com.jonata.datasource.api.service

import android.content.Context
import com.jonata.datasource.api.TokenManager
import com.jonata.datasource.utils.toLocalDateTime
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthInterceptor @Inject constructor(
    @ApplicationContext context: Context,
    private val tokenManager: TokenManager
    ) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val accessToken = runBlocking { tokenManager.getAccessToken() }
        val expiresAt = runBlocking { tokenManager.getExpiresIn()?.toLocalDateTime() }

        // Adiciona token no header
        val request = originalRequest.newBuilder()
            .apply {
                if (!accessToken.isNullOrEmpty()) {
                    addHeader("Authorization", "Bearer $accessToken")
                }
            }
            .build()

        var response = chain.proceed(request)



        return response
    }




}