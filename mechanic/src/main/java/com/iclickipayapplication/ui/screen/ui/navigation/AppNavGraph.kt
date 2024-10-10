package com.iclickipayapplication.ui.screen.ui.navigation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iclickipay.mechanic.R
import com.iclickipayapplication.common.constants.GREY
import com.iclickipayapplication.common.constants.HORIZONAL_PADDING
import com.iclickipayapplication.common.ui.components.ButtonComponent
import com.iclickipayapplication.common.ui.components.HeaderComponent
import com.iclickipayapplication.ui.screen.data.models.Mechanic
import com.iclickipayapplication.ui.screen.ui.screens.InfoScreen
import com.iclickipayapplication.ui.screen.ui.screens.MechanicDetailScreen
import com.iclickipayapplication.ui.screen.ui.screens.MechanicHomeScreen
import com.iclickipayapplication.ui.screen.ui.screens.OrderScreen

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = "home") {
        composable(route = "home") {
            HomeScreen(
                mainNavController = navController,
                appLevelNavController = nav
            )
        }
        composable(route = "mechanic_info") {
            InfoScreen(
                navController = nav
            )
        }
        composable(route = "mechanic_home") {
            MechanicHomeScreen(
                navController = nav
            )
        }
        composable(route = "mechanic_details/{mechanicId}") { backStackEntry ->
            val mechanicId = backStackEntry.arguments?.getString("mechanicId")
            val mechanic = Mechanic.listOfMechanics.find { it.id.toString() == mechanicId }
            if (mechanic != null) {
                MechanicDetailScreen(
                    navController = nav,
                    mechanic = mechanic
                )
            }
        }
        composable(route = "order/{mechanicId}") { backStackEntry ->
            val mechanicId = backStackEntry.arguments?.getString("mechanicId")
            val mechanic = Mechanic.listOfMechanics.find { it.id.toString() == mechanicId }
            if (mechanic != null) {
                OrderScreen(
                    navController = nav,
                    mechanic = mechanic
                )
            }
        }
    }
}

@Composable
fun HomeScreen(
    mainNavController: NavHostController,
    appLevelNavController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Header
        HeaderComponent(
            onClick = {
                mainNavController.navigate("MAIN")
            },
            modifier = Modifier
                .weight(.2f)
                .fillMaxWidth()
                .padding(vertical = 40.dp, horizontal = HORIZONAL_PADDING),
        )
        Column(
            modifier = Modifier
                .padding(horizontal = HORIZONAL_PADDING)
                .weight(.7f)
                .fillMaxWidth()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.mechanichome),
                contentDescription = "Mechanic Home"
            )
            Text(
                text = "Mechanic",
                modifier = Modifier.padding(top = 25.dp),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color(GREY)
            )
        }
        Row(
            modifier = Modifier
                .weight(.2f)
                .padding(horizontal = HORIZONAL_PADDING)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ButtonComponent(
                onclick = {
                    appLevelNavController.navigate("mechanic_info")
                },
                text = "Let's go",
                fillwidth = true
            )
        }
    }
}
