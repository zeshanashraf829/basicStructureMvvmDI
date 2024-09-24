package com.android.goally.util

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context) {

    private val appContext = context.applicationContext

    private val preference: SharedPreferences
        get() = appContext.getSharedPreferences("GoallyPreferenceFile", Context.MODE_PRIVATE)


    fun saveString(key: String, value: String) {
        preference.edit().putString(key, value).apply()
    }

    fun getString(key: String, default: String? = null): String? {
        return preference.getString(key, default)
    }


    fun saveInt(key: String, value: Int) {
        preference.edit().putInt(key, value).apply()
    }

    fun getInt(key: String, defalultVal: Int = 0): Int {
        return preference.getInt(key, defalultVal)
    }

    fun saveLong(key: String, value: Long) {
        preference.edit().putLong(key, value).apply()
    }

    fun getLong(key: String): Long {
        return preference.getLong(key, 0)
    }

    fun saveBoolean(key: String, value: Boolean) {
        preference.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return preference.getBoolean(key, false)
    }

    fun remove(key: String) {
        preference.edit().remove(key).apply()
    }


    companion object {
//        const val BASE_URL = "base_url"
    }

}