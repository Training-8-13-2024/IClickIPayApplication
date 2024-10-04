package com.hemanth.iclickipayapplication.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hemanth.iclickipayapplication.ui.screens.Home
import com.hemanth.iclickipayapplication.ui.screens.InfoScreen
import com.hemanth.iclickipayapplication.ui.screens.LoginScreen
import com.hemanth.iclickipayapplication.ui.screens.MainScreen


@Composable
fun Navigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            Home(
                navController
            )
        }
        composable("info") {
            InfoScreen()
        }
        composable("login") {
            LoginScreen(
                navController
            )
        }
        composable("main") {
            MainScreen(navController)
        }
    }
}