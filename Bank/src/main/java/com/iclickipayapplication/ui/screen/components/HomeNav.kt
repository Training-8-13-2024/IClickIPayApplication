package com.iclickipayapplication.ui.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.bank.R
import com.iclickipayapplication.ui.screen.data.models.InnerNav

@Composable
fun HomeNav(
    items: List<InnerNav>,
    currentScreen: InnerNav,
    onScreenSelected: (InnerNav) -> Unit
) {
    val borderThickness = 5f
    val borderColor = colorResource(id = R.color.border_grey)
    val selectedColor = colorResource(id = R.color.orange)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .height(40.dp)
            .drawBehind {
                val y = size.height - borderThickness / 2
                drawLine(
                    color = borderColor,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = borderThickness
                )
            }
    ) {
        items.forEach { screen ->
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable { onScreenSelected(screen) }
                    .then (
                        if(currentScreen == screen) Modifier.drawBehind {
                        val y = size.height - borderThickness / 2
                        drawLine(
                            color = selectedColor,
                            start = Offset(0f, y),
                            end = Offset(size.width, y),
                            strokeWidth = borderThickness
                        )
                    }
                        else Modifier
                    )
                ,
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = screen.route,
                    color = if (screen == currentScreen) Color.Black else Color.Gray,
                    fontSize = 20.sp,
                )
            }
        }
    }
}