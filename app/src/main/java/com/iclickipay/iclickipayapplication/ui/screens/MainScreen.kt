package com.iclickipay.iclickipayapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController) {
    Column {
        Button(onClick = { navController.navigate("mechanic") }) {
            Text("Go to Mechanic")
        }
        Button(onClick = { navController.navigate("bank") }) {
            Text("Go to Bank")
        }
        Button(onClick = { navController.navigate("tinder") }) {
            Text("Go to Tinder")
        }
        Button(onClick = { navController.navigate("doctor") }) {
            Text("Go to Doctor")
        }
        Button(onClick = { navController.navigate("hotel") }) {
            Text("Go to Hotel")
        }
        Button(onClick = { navController.navigate("learn") }) {
            Text("Go to Learn")
        }
    }
}