package com.jonata.datasource.local.preferences.contracts

import com.jonata.datasource.local.preferences.CryptoDataPreferences
import com.jonata.datasource.local.preferences.DefaultDataStore

interface DataPreferencesManager {

    fun crypto(fileName: String) : DataPreferences

    fun default(fileName: String) : DataPreferences

}