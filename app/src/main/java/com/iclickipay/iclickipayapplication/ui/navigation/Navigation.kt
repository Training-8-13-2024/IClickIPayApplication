package com.iclickipay.iclickipayapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iclickipay.iclickipayapplication.ui.screens.Home
import com.iclickipay.iclickipayapplication.ui.screens.InfoScreen
import com.iclickipay.iclickipayapplication.ui.screens.LoginScreen
import com.iclickipay.iclickipayapplication.ui.screens.MainScreen
import hemanth.doctor.ui.DoctorScreen

import com.iclickipay.iclickipayapplication.ui.screens.SignUpScreen
import com.iclickipayapplication.ui.TinderNavigation
import com.iclickipayapplication.ui.screen.BankScreen
import com.iclickipayapplication.ui.screen.HotelScreen
import com.iclickipayapplication.ui.screen.LearnScreen
import com.iclickipayapplication.ui.screen.MechanicScreen
import com.iclickipayapplication.ui.screen.TinderScreen
import com.iclickipayapplication.ui.screen.ui.BankScreen

enum class Navigation {
    HOME, INFO, LOGIN, MAIN, DOCTOR, SIGNUP, MECHANIC, BANK, TINDER, HOTEL, LEARN
}

sealed class NavigationPaths {

}

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Navigation.HOME.name
    ) {
        composable(Navigation.HOME.name) {
            Home(navController)
        }
        composable(Navigation.INFO.name) {
            InfoScreen(navController)
        }
        composable(Navigation.LOGIN.name) {
            LoginScreen(
                navController
            )
        }
        composable(Navigation.MAIN.name) {
            MainScreen(navController)
        }
        composable(Navigation.SIGNUP.name) {
            SignUpScreen(navController)
        }
        composable(Navigation.DOCTOR.name) {
            DoctorScreen(navController)
        }
        composable(Navigation.MECHANIC.name) {
            MechanicScreen(navController)
        }
        composable(Navigation.BANK.name) {
            BankScreen(navController)
        }
        composable(Navigation.TINDER.name) {
            TinderNavigation(navController)
        }
        composable(Navigation.HOTEL.name) {
            HotelScreen(navController)
        }
        composable(Navigation.LEARN.name) {
            LearnScreen(navController)
        }
    }
}