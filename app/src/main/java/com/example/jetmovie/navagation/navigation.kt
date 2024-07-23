package com.example.jetmovie.navagation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetmovie.screen.DetailsScreen
import com.example.jetmovie.screen.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.HomeScreen.name) {
        composable(Screens.HomeScreen.name) {
            //where path should lead
            HomeScreen(navController = navController)
        }

        //www.googlr.com/details-screen/id=34
        composable(
            Screens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {
                type = NavType.StringType
            }
            )
        ) {
            backStackEntry ->
            DetailsScreen(navController = navController, movieId = backStackEntry.arguments?.getString("movie"))
        }

    }

}