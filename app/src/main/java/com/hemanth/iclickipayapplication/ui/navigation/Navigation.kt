package com.hemanth.iclickipayapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hemanth.iclickipayapplication.ui.screens.Home
import com.hemanth.iclickipayapplication.ui.screens.InfoScreen
import com.hemanth.iclickipayapplication.ui.screens.LoginScreen
import com.hemanth.iclickipayapplication.ui.screens.MainScreen
import hemanth.doctor.ui.DoctorScreen

import com.hemanth.iclickipayapplication.ui.screens.SignUpScreen

enum class Navigation {
    HOME, INFO, LOGIN, MAIN, DOCTOR, SIGNUP
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
        composable(Navigation.DOCTOR.name) {
            DoctorScreen(navController)
        }
        composable(Navigation.SIGNUP.name) {
            SignUpScreen()
        }
    }
}