package com.jonata.news.di

import com.jonata.domain.repository.AuthRepository
import com.jonata.domain.usecase.login.GetUserDataUseCase
import com.jonata.domain.usecase.login.IsLoggedInUseCase
import com.jonata.domain.usecase.login.SignInUseCase
import com.jonata.domain.usecase.login.LogoutUseCase
import com.jonata.domain.usecase.login.SignUpUseCase
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
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher
    ): SignInUseCase{
        return SignInUseCase(authRepository,coroutineDispatcher)
    }

    @Provides
    @Singleton
    fun providesLogoutUseCase(
        authRepository: AuthRepository,
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher) : LogoutUseCase{
        return LogoutUseCase(authRepository,coroutineDispatcher)
    }

    @Provides
    @Singleton
    fun providesIsLoggedInUseCase(
        authRepository: AuthRepository,
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher)
        = IsLoggedInUseCase(authRepository,coroutineDispatcher)


    @Provides
    @Singleton
    fun providesGetUserDataUseCase(
        authRepository: AuthRepository,
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher
    ) = GetUserDataUseCase(authRepository,coroutineDispatcher)


    @Provides
    @Singleton
    fun providesSignUpUseCase(
        authRepository: AuthRepository,
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher
    )= SignUpUseCase(authRepository,coroutineDispatcher)


}