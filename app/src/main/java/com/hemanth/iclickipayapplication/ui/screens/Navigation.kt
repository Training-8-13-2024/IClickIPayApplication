package com.hemanth.iclickipayapplication.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            MainScreen(navController)
        }
        composable("mechanic") {
            //MechanicScreen(navController)
        }
        composable("bank") {
         //   BankScreen(navController)
        }
        composable("tinder") {
           // TinderScreen(navController)
        }
        composable("doctor") {
           // DoctorScreen(navController)
        }
        composable("hotel") {
          //  HotelScreen(navController)
        }
        composable("learn") {
          //  LearnScreen(navController)
        }
    }
}