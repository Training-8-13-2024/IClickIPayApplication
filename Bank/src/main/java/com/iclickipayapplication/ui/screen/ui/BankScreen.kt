package com.iclickipayapplication.ui.screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.iclickipayapplication.common.constants.BACKGROUND_COLOR
import com.iclickipayapplication.ui.screen.ui.components.bottomNavigation
import com.iclickipayapplication.ui.screen.data.models.Bankscreens
import com.iclickipayapplication.ui.screen.ui.screens.HomeScreen
import com.iclickipayapplication.ui.screen.ui.screens.MessageScreen
import com.iclickipayapplication.ui.screen.ui.screens.SendScreen
import com.iclickipayapplication.ui.screen.ui.screens.SettingScreen
import com.iclickipayapplication.ui.screen.ui.screens.WalletScreen


@Composable
fun BankScreen(navController: NavHostController) {

    val currentScreen = remember { mutableStateOf<Bankscreens>(Bankscreens.Home) }
    val screens = listOf(
        Bankscreens.Home,
        Bankscreens.Wallet,
        Bankscreens.Send(),
        Bankscreens.Message,
        Bankscreens.Settings
    )
    Scaffold(
        bottomBar = {
            if (currentScreen.value != Bankscreens.Send()){
                bottomNavigation(
                    bottomNavItems = screens,
                    currentScreen = currentScreen.value,
                    onScreenSelected = {
                        currentScreen.value = it
                    }
                )
            }
        },
        modifier = Modifier
            .padding(WindowInsets.navigationBars.asPaddingValues())
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BACKGROUND_COLOR)
        ) {
            when (currentScreen.value) {
                Bankscreens.Home -> HomeScreen()
                Bankscreens.Wallet -> WalletScreen(innerPadding)
                Bankscreens.Message -> MessageScreen()
                Bankscreens.Settings -> SettingScreen()
                is Bankscreens.Send -> SendScreen(
                    goBack = { currentScreen.value = it }
                )
            }
        }
    }
}


@Composable
@Preview
fun BottomNavigationPreview() {
    BankScreen(navController = NavHostController(LocalContext.current))
}