package com.dimitrisligi.listofapirequests


import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.fragment.NavHostFragment



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTheBottomNavMenu()
    }

    private fun setTheBottomNavMenu() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.homefragmentContainerView) as NavHostFragment?
        val navController = navHostFragment!!.navController
        setupActionBarWithNavController(navController)
        bottomNavigationView.setupWithNavController(navController)
        actionBar?.setDisplayShowHomeEnabled(false)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}