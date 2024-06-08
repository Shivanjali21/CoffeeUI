package com.practice.coffeeapp.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.practice.coffeeapp.R
import com.practice.coffeeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
       ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
       installSplashScreen()

       super.onCreate(savedInstanceState)
       setContentView(binding.root)

       val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentCV) as NavHostFragment
       navController = navHostFragment.navController
    }
}