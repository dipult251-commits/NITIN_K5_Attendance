package com.nitink5.attendance.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.nitink5.attendance.R
import com.nitink5.attendance.data.PreferenceManager
import com.nitink5.attendance.databinding.ActivityMainBinding
import com.nitink5.attendance.ui.fragments.HomeFragment
import com.nitink5.attendance.ui.fragments.HistoryFragment
import com.nitink5.attendance.ui.fragments.CalendarFragment
import com.nitink5.attendance.ui.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var preferenceManager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferenceManager = PreferenceManager(this)
        applyTheme()

        setSupportActionBar(binding.toolbar)
        setupBottomNavigation()
        loadFragment(HomeFragment())
    }

    private fun applyTheme() {
        if (preferenceManager.isDarkMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_history -> loadFragment(HistoryFragment())
                R.id.nav_calendar -> loadFragment(CalendarFragment())
                R.id.nav_settings -> loadFragment(SettingsFragment())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
