package com.iclickipayapplication.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iclickipayapplication.ui.screen.FilterScreen
import com.iclickipayapplication.ui.screen.HotelDetailScreen
import com.iclickipayapplication.ui.screen.HotelMainScreen
import com.iclickipayapplication.ui.screen.OrderScreen
import com.iclickipayapplication.ui.screen.SearchHotelScreen


enum class HotelNavigation {
    HOME, SEARCHHOTEL, DETAIL, FILTER, ORDER
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
        composable(
            HotelNavigation.FILTER.name
        ) {
             FilterScreen()
        }
        composable(
            "${HotelNavigation.DETAIL.name}/{hotel}",
            arguments = listOf(navArgument("hotel") { type = NavType.StringType })
        ) {
            val hotel = it.arguments?.getString("hotel")
            hotel?.let {
                HotelDetailScreen(hotel = hotel, navController = hotelNavController)
            } ?: run {
                navigateToHome()
            }
        }
        composable(
            HotelNavigation.ORDER.name
        ) {
            OrderScreen()
        }
    }
}