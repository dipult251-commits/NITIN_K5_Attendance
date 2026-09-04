package com.nitink5.attendance.data

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("nitin_k5_prefs", Context.MODE_PRIVATE)

    fun isDarkMode(): Boolean {
        return sharedPreferences.getBoolean("dark_mode", false)
    }

    fun setDarkMode(isDark: Boolean) {
        sharedPreferences.edit().putBoolean("dark_mode", isDark).apply()
    }

    fun getLastBackupTime(): Long {
        return sharedPreferences.getLong("last_backup", 0L)
    }

    fun setLastBackupTime(time: Long) {
        sharedPreferences.edit().putLong("last_backup", time).apply()
    }
}
