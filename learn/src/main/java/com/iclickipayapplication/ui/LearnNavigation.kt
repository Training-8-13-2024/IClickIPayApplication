package com.iclickipayapplication.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iclickipayapplication.ui.screen.LearnHomeScreen
import com.iclickipayapplication.ui.screen.LearnScreen
import com.iclickipayapplication.ui.screen.LearnTeacherScreen

enum class LearnNavigationData {
    HOME, SCREEN2, MAIN
}
@Composable
fun LearnNavigation(navController: NavHostController? = null) {
    val learnNavController = rememberNavController()


    NavHost(
        navController = learnNavController,
        startDestination = LearnNavigationData.HOME.name
    ) {
        composable(LearnNavigationData.HOME.name) { LearnScreen(navController = learnNavController) }
        composable(LearnNavigationData.SCREEN2.name) { LearnTeacherScreen(navController = learnNavController) }
        composable(
            route = LearnNavigationData.MAIN.name + "/{lesson}/{level}",
            arguments = listOf(
                navArgument("lesson") { type = NavType.StringType },
                navArgument("level") { type = NavType.StringType }
            )
        ) {backStackEntry ->
            val lesson = backStackEntry.arguments?.getString("lesson")?:""
            val level = backStackEntry.arguments?.getString("level")
            LearnHomeScreen(navController = learnNavController, lesson = lesson, level = level)
        }




//        composable(
//            route = TinderNavigationData.DETAILS.name + "/{id}",
//            arguments = listOf(navArgument("id") { type = NavType.IntType })
//        ) { backStackEntry ->
//            // Extract the 'id' argument
//            val id = backStackEntry.arguments?.getInt("id") ?: -1
//            TinderDetailsScreen(navController = tinderNavController, id = id)
//        }


    }
}