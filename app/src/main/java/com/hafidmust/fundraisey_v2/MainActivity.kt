package com.hafidmust.fundraisey_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val navView : BottomNavigationView = findViewById(R.id.nav_view)
//        val navController = findNavController(R.id.nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration.Builder(
//            R.id.navigation_home,R.id.navigation_portfolio,R.id.navigation_history,R.id.navigation_information
//        ).build()
//        setupActionBarWithNavController(navController,appBarConfiguration)
//        navView.setupWithNavController(navController)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController =navHostFragment.navController
        val navView : BottomNavigationView = findViewById(R.id.nav_view)
        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment ||
                destination.id == R.id.portfolioFragment ||
                destination.id == R.id.historyFragment ||
                destination.id == R.id.informationFragment){
                navView.visibility = View.VISIBLE
            }else {
                navView.visibility = View.GONE
            }
        }

    }
}