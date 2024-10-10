package com.iclickipayapplication.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iclickipayapplication.ui.screen.LearnBookingScreen
import com.iclickipayapplication.ui.screen.LearnFilterScreen
import com.iclickipayapplication.ui.screen.LearnHomeScreen
import com.iclickipayapplication.ui.screen.LearnMapScreen
import com.iclickipayapplication.ui.screen.LearnOrderScreen
import com.iclickipayapplication.ui.screen.LearnScreen
import com.iclickipayapplication.ui.screen.LearnTeacherScreen

enum class LearnNavigationData {
    HOME, SCREEN2, MAIN, FILTER, BOOKING, ORDER, MAP
}
@Composable
fun LearnNavigation(navController: NavHostController) {
    val learnNavController = rememberNavController()


    NavHost(
        navController = learnNavController,
        startDestination = LearnNavigationData.HOME.name
    ) {
        composable(LearnNavigationData.HOME.name) { LearnScreen(navController = learnNavController) }
        composable(LearnNavigationData.SCREEN2.name) { LearnTeacherScreen(navController = learnNavController) }
        composable(LearnNavigationData.FILTER.name) { LearnFilterScreen(navController = learnNavController) }
        composable(LearnNavigationData.BOOKING.name) { LearnBookingScreen(navController = learnNavController) }
        composable(
            route = LearnNavigationData.ORDER.name + "/{selectedDate}",
            arguments = listOf(
                navArgument("selectedDate") { type = NavType.StringType }
            )
            ) {backStackEntry ->
            val selectedDate = backStackEntry.arguments?.getString("selectedDate")?:""
            LearnOrderScreen(navController = learnNavController, selectedDate = selectedDate) }
        composable(LearnNavigationData.MAP.name) { LearnMapScreen(navController = learnNavController) }
        composable(LearnNavigationData.MAIN.name) { LearnHomeScreen(navController = learnNavController) }




    }
}