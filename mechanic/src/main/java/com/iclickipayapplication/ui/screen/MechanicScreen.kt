package com.iclickipayapplication.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.iclickipayapplication.common.constants.BACKGROUND_COLOR
import com.iclickipayapplication.ui.screen.ui.navigation.AppNavGraph

@Composable
fun MechanicScreen(
    navController: NavHostController
) {
    Scaffold() { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(color = BACKGROUND_COLOR)
        ) {
            AppNavGraph(navController = navController)
        }
    }
}

