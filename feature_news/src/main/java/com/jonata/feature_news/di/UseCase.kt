package com.jonata.feature_news.di

import com.jonata.domain.repository.AuthRepository
import com.jonata.domain.usecase.LoginUseCase
import com.jonata.domain.model.LoginRequest
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCase{




    @Provides
    @Singleton
    fun providesLoginUseCase(repository: AuthRepository): LoginUseCase{
        return LoginUseCase(repository)
    }

}