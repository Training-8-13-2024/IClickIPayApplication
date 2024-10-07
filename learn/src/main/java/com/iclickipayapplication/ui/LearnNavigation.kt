package com.iclickipayapplication.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iclickipayapplication.ui.screen.LearnScreen

enum class LearnNavigationData {
    HOME
}
@Composable
fun LearnNavigation(navController: NavHostController? = null) {
    val learnNavController = rememberNavController()


    NavHost(
        navController = learnNavController,
        startDestination = LearnNavigationData.HOME.name
    ) {
        composable(LearnNavigationData.HOME.name) { LearnScreen(navController = learnNavController) }
//        composable(TinderNavigationData.SCREEN2.name) { TinderMeetScreen(navController = tinderNavController) }
//        composable(TinderNavigationData.PHOTO.name) { TinderPhotoScreen(navController = tinderNavController) }
//        composable(TinderNavigationData.PROFILE.name) { ProfileCompletionScreen(navController = tinderNavController) }
//        composable(TinderNavigationData.MAP.name) { TinderMapScreen(navController = tinderNavController) }
//        composable(TinderNavigationData.TUTORIAL.name) { TinderTutorialScreen(navController = tinderNavController) }
//        composable(TinderNavigationData.MAIN.name) { TinderMainScreen(navController = tinderNavController) }
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