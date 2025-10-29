package com.jonata.datasource.api

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = "auth_prefs")

class TokenManager @Inject constructor(private val context: Context) {

    private val deContext: Context = context.createDeviceProtectedStorageContext()


    suspend fun saveTokens(
        idToken: String,
        refreshToken: String,
        expiresIn: String,
        localId: String
    ) {



        deContext.dataStore.edit { prefs ->
            idToken.let { prefs[stringPreferencesKey("id_token")] = it }
            refreshToken.let { prefs[stringPreferencesKey("refresh_token")] = it }
            expiresIn.let { prefs[stringPreferencesKey("expires_in")] = it }
            localId.let { prefs[stringPreferencesKey("local_id")] = it }
        }
    }

    suspend fun getExpiresIn(): String? {
        return deContext.dataStore.data
            .map { it[stringPreferencesKey("expires_in")] }
            .firstOrNull()
    }

    suspend fun getAccessToken(): String? {
        return deContext.dataStore.data
            .map { it[stringPreferencesKey("access_token")] }
            .firstOrNull()
    }

    suspend fun getRefreshToken(): String? {
        return deContext.dataStore.data
            .map { it[stringPreferencesKey("refresh_token")] }
            .firstOrNull()
    }


    suspend fun cleanTokenManager(){
        deContext.dataStore.edit { prefs ->
            prefs.remove(stringPreferencesKey("id_token"))
            prefs.remove(stringPreferencesKey("refresh_token"))
            prefs.remove(stringPreferencesKey("expires_in"))
            prefs.remove(stringPreferencesKey("local_id"))
        }
    }

    suspend fun tokenIdIsNull() : Boolean{

        val idTokenFlow: Flow<String?> = deContext.dataStore.data
            .map { prefs ->
                prefs[stringPreferencesKey("id_token")]
            }

       return idTokenFlow.firstOrNull()?.let { token ->
            true
        } ?: false


    }

}
