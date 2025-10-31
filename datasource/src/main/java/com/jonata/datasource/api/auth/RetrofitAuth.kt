package com.jonata.datasource.api.auth

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitAuth {


    @Provides
    @Singleton
    fun provideRefreshRetrofit(): ApiAuthService =
        Retrofit.Builder()
            .baseUrl("https://identitytoolkit.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiAuthService::class.java)



}