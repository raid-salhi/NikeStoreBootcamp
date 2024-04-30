package com.example.nikestore
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(){
    // navController is used to navigate through screens
    val navController = rememberNavController()

    // sharedViewmodel will allow us to pass complex data between screens
    val sharedViewmodel = viewModel<SharedViewmodel>()

    NavHost(navController = navController, startDestination = "StartScreen") {
        composable(route="StartScreen"){
            StartScreen(navController)
        }
        composable(route="HomeScreen"){
            HomeScreen(navController,sharedViewmodel)
        }
        composable(route="DetailsScreen"){
            DetailsScreen(navController,sharedViewmodel)
        }
    }
}