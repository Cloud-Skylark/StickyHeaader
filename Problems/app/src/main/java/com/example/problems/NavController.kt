package com.example.problems

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavController() {
    /*  val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Form") {
        composable("Form") {
            Form(navController)
        } // Only one definition for "Form"
        composable(
            route = "State/{mail}/{password}",
            arguments = listOf(
                navArgument("mail") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val mail = backStackEntry.arguments?.getString("mail")
            val password = backStackEntry.arguments?.getString("password")
            State(navController, mail, password) // Pass arguments to State
        }
    }*/

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Tryout")
    {
        composable("Tryout")
        {
            Tryout(navController)
        }
//        composable(
//            route = "Try/{password}",
//            arguments = listOf(
//                navArgument("password") { type = NavType.StringType }
//            )
//        ) { backStackEntry ->
//            val password = backStackEntry.arguments?.getString("password")
//            Try(navController, password)
//        }
        composable("Try/{password}") {
            backStackEntry ->
                Try(navController, backStackEntry.arguments?.getString("password"))
        }
    }
}
