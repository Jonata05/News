package com.jonata.datasource.local.preferences

import android.content.Context
import com.jonata.datasource.local.preferences.contracts.DataPreferences
import com.jonata.datasource.local.preferences.contracts.DataPreferencesManager

class DataPreferencesManagerImpl (private val context: Context): DataPreferencesManager {

    override fun crypto(fileName: String) : DataPreferences= CryptoDataPreferences(context,fileName)

    override fun default(fileName: String) : DataPreferences = DefaultDataStore(context,fileName)
}