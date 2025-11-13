package com.jonata.datasource.local.localdatasourceimpl

import android.content.Context
import com.jonata.data.datasource.AuthLocalDataSource
import com.jonata.data.model.TokenData
import com.jonata.datasource.local.preferences.DataPreferencesManagerImpl
import com.jonata.datasource.local.preferences.contracts.DataPreferencesManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject



class AuthLocalDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    preferenceManager: DataPreferencesManager
) : AuthLocalDataSource {


    private var cachedToken: TokenData? = null
    private val fileName = "token_prefs"

    val preferences = preferenceManager.crypto(fileName)


    override fun saveToken(
        token: TokenData
    ) {

        preferences {
            saveString(KEY_ID_TOKEN, token.idToken)
            saveLong(KEY_EXPIRES_AT, token.expiresAt)
            saveString(KEY_REFRESH_TOKEN, token.refreshToken)
            saveString(KEY_NAME, token.displayName)
            saveString(KEY_EMAIL, token.email)
            saveBoolean(KEY_REGISTERED, token.registered)
            saveString(KEY_LOCAL_ID, token.localId)
        }

        cachedToken = token
    }


    override fun getToken(): TokenData {

        cachedToken?.let { return it }

        val idToken : String? = preferences.getString(KEY_ID_TOKEN)

        val refresh: String? = preferences.getString(KEY_ID_TOKEN)
        val name: String? = preferences.getString(KEY_NAME)
        val email: String? = preferences.getString(KEY_EMAIL)
        val localId: String? = preferences.getString(KEY_LOCAL_ID)
        val expiresAt: Long? = preferences.getLong(KEY_EXPIRES_AT)
        val registered: Boolean? = preferences.getBoolean(KEY_REGISTERED)



        if (idToken == null ||
            refresh == null ||
            name == null ||
            email == null ||
            localId == null ||
            expiresAt==null ||
            registered == null) {
            throw IllegalStateException("Não há token no data store ")
        }
            val token = TokenData(
                idToken = idToken,
                expiresAt = expiresAt,
                refreshToken = refresh,
                displayName = (name),
                email = (email),
                registered = registered,
                localId = localId
            )

        cachedToken = token
        return token
    }


     override fun clearToken() {
         preferences{clear()}
         cachedToken = null
    }

    override fun isLoggedIn(): Boolean = preferences.fileHasData()



    private companion object {
        const val KEY_ID_TOKEN = "id_token"
        const val KEY_REFRESH_TOKEN = "refresh_token"
        const val KEY_EXPIRES_AT = "expires_at"
        const val KEY_EMAIL = "email"
        const val KEY_NAME = "name"
        const val KEY_LOCAL_ID = "local_id"
        const val KEY_REGISTERED = "registered"
    }

}