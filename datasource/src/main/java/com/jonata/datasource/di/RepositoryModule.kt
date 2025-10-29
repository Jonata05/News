package com.jonata.datasource.di

import android.content.Context
import com.jonata.datasource.api.TokenManager
import com.jonata.datasource.repository.AuthRepositoryImpl
import com.jonata.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindLoginRequest(
        impl : AuthRepositoryImpl
    ): AuthRepository





}

@Module
@InstallIn(SingletonComponent::class)
object TokenModule {

    @Provides
    @Singleton
    fun provideTokenManager(
        @ApplicationContext context: Context
    ): TokenManager = TokenManager(context)
}