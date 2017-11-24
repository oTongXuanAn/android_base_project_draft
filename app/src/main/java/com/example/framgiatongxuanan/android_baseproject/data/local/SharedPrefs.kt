package com.example.framgiatongxuanan.android_baseproject.data.local

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by FRAMGIA\tong.xuan.an on 24/11/2017.
 */
class SharedPrefs(context: Context) {
    private val mSharedPreferences: SharedPreferences

    init {
        mSharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    @Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
    fun <T> get(key: String, clazz: Class<T>): T =
            when (clazz) {
                String::class.java -> mSharedPreferences.getString(key, "")
                Boolean::class.java->mSharedPreferences.getBoolean(key,false)

                else -> null
            } as T

    fun <T> put(key: String, data: T) {
        val editor = mSharedPreferences.edit()
        when (data) {
            is String -> editor.putString(key, data)
            is Boolean -> editor.putBoolean(key, data)
            is Float -> editor.putFloat(key, data)
            is Double -> editor.putFloat(key, data.toFloat())
            is Int -> editor.putInt(key, data)
            is Long -> editor.putLong(key, data)
        }
        editor.apply()
    }

    fun clear() {
        mSharedPreferences.edit().clear().apply()
    }

    companion object {
        val PREFS_NAME = "HouseRentSharedPreferences"
        val PREFIX = "houserent_"
        val PREF_ACCESS_TOKEN = PREFIX + "access_token"
    }
}