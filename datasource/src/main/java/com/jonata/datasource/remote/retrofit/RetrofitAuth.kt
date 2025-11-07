package com.jonata.datasource.remote.retrofit

import com.jonata.datasource.remote.api.ApiAuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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