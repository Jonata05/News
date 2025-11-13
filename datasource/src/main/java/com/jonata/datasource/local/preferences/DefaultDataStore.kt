package com.jonata.datasource.local.preferences

import android.content.Context
import androidx.core.content.edit
import com.jonata.datasource.local.preferences.contracts.DataPreferences
import javax.inject.Inject


class DefaultDataStore  @Inject constructor(
    context: Context,
    fileName: String) : DataPreferences {



    private val prefs = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)


    override fun saveString(key: String, value: String) {
        prefs.edit { putString(key, value) }
    }

    override fun getString(key: String): String? = prefs.getString(key, null)

    override fun saveLong(key: String, value: Long) {
        prefs.edit { putLong(key, value) }
    }

    override fun getLong(key: String): Long = prefs.getLong(key, 0L)

    override fun saveBoolean(key: String, value: Boolean) {
        prefs.edit { putBoolean(key, value) }
    }

    override fun getBoolean(key: String): Boolean = prefs.getBoolean(key, false)

    override fun clear() {
        prefs.edit { clear() }
    }

    override fun fileHasData(): Boolean {
        val all = prefs.all
        return all.isNotEmpty()
    }
}


