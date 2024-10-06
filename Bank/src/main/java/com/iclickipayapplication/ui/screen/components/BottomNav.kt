package com.iclickipayapplication.ui.screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.iclickipay.bank.R
import com.iclickipayapplication.ui.screen.data.models.Bankscreens

@Composable
fun bottomNavigation(
    bottomNavItems: List<Bankscreens>,
    currentScreen: Bankscreens,
    onScreenSelected: (Bankscreens) -> Unit,
) {
    BottomAppBar(
        backgroundColor = Color.White,
    ) {
        BottomNavigation(
            backgroundColor = Color.White,
            contentColor = Color(0xFF1E1F22),
            modifier = Modifier
                .fillMaxWidth()
                .height(69.dp)
        ) {
            bottomNavItems.forEach { screen ->
                val selected = screen.route == currentScreen.route
                val iconRes = screen.icon

                BottomNavigationItem(
                    selected = currentScreen.route == screen.route,
                    icon = {
                        Icon(
                            painter = painterResource(id = screen.icon),
                            contentDescription = screen.route
                        )
                    },
                    onClick = { onScreenSelected(screen) },
                    selectedContentColor = colorResource(R.color.orange),
                    unselectedContentColor = colorResource(R.color.grey)
                )
            }
        }
    }
}

