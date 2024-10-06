package com.iclickipayapplication.ui.screen.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.iclickipayapplication.ui.screen.components.bottomNavigation
import com.iclickipayapplication.ui.screen.data.models.Bankscreens
import com.iclickipayapplication.ui.screen.ui.screens.HomeScreen
import com.iclickipayapplication.ui.screen.ui.screens.MessageScreen
import com.iclickipayapplication.ui.screen.ui.screens.SendScreen
import com.iclickipayapplication.ui.screen.ui.screens.SettingScreen
import com.iclickipayapplication.ui.screen.ui.screens.WalletScreen


@Composable
fun BankScreen(navController: NavHostController) {

    val currentScreen = remember { mutableStateOf<Bankscreens>(Bankscreens.Home) }
    val screens = listOf(Bankscreens.Home, Bankscreens.Wallet,Bankscreens.Send, Bankscreens.Message, Bankscreens.Settings)
    Scaffold(
        bottomBar = {
            bottomNavigation(
                bottomNavItems = screens,
                currentScreen = currentScreen.value,
                onScreenSelected = {
                    currentScreen.value =  it
                }
            )
        },
        modifier = Modifier
            .padding(WindowInsets.navigationBars.asPaddingValues())
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            when (currentScreen.value) {
                Bankscreens.Home -> HomeScreen(
                    modifier = Modifier
                        .padding(innerPadding)
                )
                Bankscreens.Wallet -> WalletScreen()
                Bankscreens.Message -> MessageScreen()
                Bankscreens.Settings -> SettingScreen()
                Bankscreens.Send -> SendScreen()
            }
        }

    }

}


@Composable
@Preview
fun BottomNavigationPreview() {
    BankScreen(navController = NavHostController(LocalContext.current))

}