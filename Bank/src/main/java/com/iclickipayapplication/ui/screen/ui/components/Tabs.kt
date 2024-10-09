package com.iclickipayapplication.ui.screen.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.bank.R
import com.iclickipayapplication.ui.screen.data.interfaces.NavigationIntBank

@Composable
fun Tabs(
    items: List<NavigationIntBank>,
    currentScreen: NavigationIntBank,
    onScreenSelected: (NavigationIntBank) -> Unit,
    showBorder: Boolean = true,
    activeColor: Color = Color.Black,
    inactiveColor: Color = Color.Gray,
    height: Int = 40,
    horizontal: Arrangement.Horizontal = Arrangement.Center
) {
    val borderThickness = 5f
    val borderColor = colorResource(id = R.color.border_grey)
    val selectedColor = colorResource(id = R.color.orange)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .height(height.dp)
            .then(
                if (showBorder) {
                    Modifier.drawBehind {
                        val y = size.height - borderThickness / 2
                        drawLine(
                            color = borderColor,
                            start = Offset(0f, y),
                            end = Offset(size.width, y),
                            strokeWidth = borderThickness
                        )
                    }
                } else {
                    Modifier
                }
            )
    ) {
        items.forEach { screen ->
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable { onScreenSelected(screen) }
                    .then(
                        if (currentScreen == screen && showBorder) Modifier.drawBehind {
                            val y = size.height - borderThickness / 2
                            drawLine(
                                color = selectedColor,
                                start = Offset(0f, y),
                                end = Offset(size.width, y),
                                strokeWidth = borderThickness
                            )
                        }
                        else Modifier
                    ),
                horizontalArrangement = horizontal,
            ) {
                if (screen.icon != null) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = screen.icon!!),
                            contentDescription = screen.label,
                            tint = if (screen == currentScreen) activeColor else inactiveColor
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = screen.label ?: screen.routes,
                            color = if (screen == currentScreen) activeColor else inactiveColor,
                            fontSize = 15.sp,
                        )
                    }
                } else {
                    Text(
                        text = screen.label ?: screen.routes,
                        color = if (screen == currentScreen) activeColor else inactiveColor,
                        fontSize = 20.sp,
                    )
                }

            }
        }
    }
}