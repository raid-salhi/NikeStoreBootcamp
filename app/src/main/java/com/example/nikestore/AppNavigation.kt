package com.example.nikestore
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "StartScreen") {
        composable(route="StartScreen"){
            StartScreen(navController)
        }
        composable(route="HomeScreen"){
            HomeScreen(navController)
        }
        composable(route="DetailsScreen"){
            DetailsScreen(navController)
        }
    }
}