package com.iclickipayapplication.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iclickipayapplication.ui.screen.HotelDetailScreen
import com.iclickipayapplication.ui.screen.HotelMainScreen
import com.iclickipayapplication.ui.screen.SearchHotelScreen


enum class HotelNavigation {
    HOME, SEARCHHOTEL, DETAIL
}

@Composable
fun HotelScreen(navController: NavHostController) {

    val hotelNavController = rememberNavController()

    fun navigateToHome() {
        navController.navigate("HOME")
    }

    NavHost(navController = hotelNavController, startDestination = HotelNavigation.DETAIL.name) {
        composable(HotelNavigation.HOME.name) {
            HotelMainScreen(hotelNavController)
        }
        composable(HotelNavigation.DETAIL.name) {
            HotelDetailScreen(hotelNavController)
        }
        composable(
            HotelNavigation.SEARCHHOTEL.name
        ) {
            SearchHotelScreen(hotelNavController)
        }
    }

}