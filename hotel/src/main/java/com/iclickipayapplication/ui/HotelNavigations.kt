package com.iclickipayapplication.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iclickipayapplication.ui.screen.HotelMainScreen
import com.iclickipayapplication.ui.screen.SearchHotelScreen


enum class HotelNavigation {
    HOME, SEARCHHOTEL
}

@Composable
fun HotelScreen(navController: NavHostController) {

    val hotelNavController = rememberNavController()

    fun navigateToHome() {
        navController.navigate("HOME")
    }

    NavHost(navController = hotelNavController, startDestination = HotelNavigation.HOME.name) {
        composable(HotelNavigation.HOME.name) {
            HotelMainScreen(hotelNavController)
        }
        composable(
            HotelNavigation.SEARCHHOTEL.name
        ) {
            SearchHotelScreen(hotelNavController)
        }
    }

}