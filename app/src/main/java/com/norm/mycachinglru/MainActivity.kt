package com.norm.mycachinglru

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.norm.mycachinglru.presentation.MainScreen
import com.norm.mycachinglru.presentation.ProductsScreen
import com.norm.mycachinglru.ui.theme.MyCachingLRUTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCachingLRUTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "main_screen"
                    ) {
                        composable(route = "main_screen") {
                            MainScreen(navController = navController)
                        }

                        composable(route = "products_screen") {
                            ProductsScreen()
                        }
                    }
                }
            }
        }
    }
}