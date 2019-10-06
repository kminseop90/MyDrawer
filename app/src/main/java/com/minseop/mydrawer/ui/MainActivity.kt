package com.minseop.mydrawer.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.minseop.mydrawer.R

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val navController = Navigation.findNavController(MainActivity@this, R.id.nav_host_fragment)
        when (item.itemId) {
            R.id.navigation_home -> {
                navController.navigate(R.id.nav_main_to_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                navController.navigate(R.id.nav_main_to_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                navController.navigate(R.id.nav_main_to_setting)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
