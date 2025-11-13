package com.jonata.datasource.remote.retrofit

import android.content.Context
import com.jonata.datasource.local.localdatasourceimpl.AuthLocalDataSourceImpl
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthInterceptor @Inject constructor(
    @ApplicationContext context: Context,
    private val authLocalDataSourceImpl: AuthLocalDataSourceImpl
    ) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()


        val request = originalRequest.newBuilder().build()

        val response = chain.proceed(request)



        return response
    }




}