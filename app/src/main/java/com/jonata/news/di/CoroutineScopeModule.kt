package com.jonata.news.di

import com.jonata.domain.usecase.generics.UseCaseExecutor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoroutineScopeModule {


    @Provides
    @Singleton
    fun provideCoroutineScope(): CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.IO)


    @Provides
    @Singleton
    fun provideUseCaseExecutor(
        scope: CoroutineScope
    ): UseCaseExecutor = UseCaseExecutor(scope)


}