package com.jonata.datasource.di

import android.content.Context
import com.jonata.data.datasource.AuthLocalDataSource
import com.jonata.data.datasource.AuthRemoteDataSource
import com.jonata.datasource.local.localdatasourceimpl.AuthLocalDataSourceImpl
import com.jonata.datasource.local.preferences.DataPreferencesManagerImpl
import com.jonata.datasource.local.preferences.contracts.DataPreferencesManager
import com.jonata.datasource.remote.AuthRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {


    @Binds
    @Singleton
    abstract fun bindAuthRemoteDataSource(
        impl: AuthRemoteDataSourceImpl
    ): AuthRemoteDataSource


    @Binds
    @Singleton
    abstract fun bindAuthLocalDataSource(
        impl: AuthLocalDataSourceImpl
    ): AuthLocalDataSource



}