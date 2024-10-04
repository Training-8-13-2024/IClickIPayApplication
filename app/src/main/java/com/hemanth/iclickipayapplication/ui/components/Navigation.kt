package com.hemanth.iclickipayapplication.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hemanth.iclickipayapplication.ui.screens.Home
import com.hemanth.iclickipayapplication.ui.screens.InfoScreen
import com.hemanth.iclickipayapplication.ui.screens.LoginScreen
import com.hemanth.iclickipayapplication.ui.screens.MainScreen
import com.hemanth.iclickipayapplication.ui.screens.SignUpScreen


@Composable
fun Navigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController, startDestination = "home"
    ) {
        composable("home") {
            Home(navController)
        }
        composable("info") {
            InfoScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("main") {
            MainScreen(navController)
        }
        composable("signup") {
            SignUpScreen()
        }
    }
}