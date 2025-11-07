package com.jonata.datasource.di

import android.content.Context
import com.jonata.datasource.local.preferences.DataPreferencesManagerImpl
import com.jonata.datasource.local.preferences.contracts.DataPreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideDataPreferencesManagerImplFactory(
        @ApplicationContext context: Context
    ) : DataPreferencesManager = DataPreferencesManagerImpl(context)





}