package com.jonata.datasource.local.preferences

import android.content.Context
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.jonata.datasource.local.preferences.contracts.DataPreferences
import javax.inject.Inject

class CryptoDataPreferences @Inject constructor(
    context: Context,
    fileName: String
) : DataPreferences {

    private val masterKey by lazy {
        MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
    }

    private val prefs by lazy {
        EncryptedSharedPreferences.create(
            context,
            fileName,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

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
