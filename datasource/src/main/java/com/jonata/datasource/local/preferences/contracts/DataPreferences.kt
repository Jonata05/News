package com.jonata.datasource.local.preferences.contracts

interface DataPreferences {


    fun saveString(key: String, value: String)

    fun getString(key: String): String?

    fun saveLong(key: String, value: Long)
    fun getLong(key: String): Long

    fun saveBoolean(key: String, value: Boolean)
    fun getBoolean(key: String): Boolean

    fun clear()

    operator fun invoke(block: DataPreferences.() -> Unit) {
        this.block()
    }

    fun fileHasData() : Boolean


}