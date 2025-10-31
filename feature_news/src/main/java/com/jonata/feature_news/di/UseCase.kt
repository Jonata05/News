package com.jonata.feature_news.di

import com.jonata.domain.repository.AuthRepository
import com.jonata.domain.repository.TokenRepository
import com.jonata.domain.usecase.login.GetUserDataUseCase
import com.jonata.domain.usecase.login.LoginUseCase
import com.jonata.domain.usecase.login.LogoutUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCase{

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class IoDispatcher


    @IoDispatcher
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun providesLoginUseCase(
        authRepository: AuthRepository,
        tokenRepository: TokenRepository,
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher
    ): LoginUseCase{
        return LoginUseCase(authRepository,tokenRepository,coroutineDispatcher)
    }

    @Provides
    @Singleton
    fun providesLogoutUseCase(
        tokenRepository: TokenRepository,
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher) : LogoutUseCase{
        return LogoutUseCase(tokenRepository,coroutineDispatcher)
    }

    @Provides
    @Singleton
    fun providesGetUserDataUseCase(
        tokenRepository: TokenRepository,
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetUserDataUseCase{
        return GetUserDataUseCase(tokenRepository,coroutineDispatcher)
    }

}