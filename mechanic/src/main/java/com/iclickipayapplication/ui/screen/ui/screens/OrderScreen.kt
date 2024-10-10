package com.iclickipayapplication.ui.screen.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.mechanic.R
import com.iclickipayapplication.common.constants.HORIZONAL_PADDING
import com.iclickipayapplication.common.constants.ORANGE
import com.iclickipayapplication.common.constants.VERTICAL_PADDING
import com.iclickipayapplication.common.ui.components.ButtonComponent
import com.iclickipayapplication.ui.screen.data.models.Mechanic


@Composable
fun OrderScreen(
    navController: NavHostController,
    mechanic: Mechanic
) {
    val orange = colorResource(ORANGE)
    val borderThickness = 1f
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(.4f)
                .background(color = orange)
                .padding(horizontal = HORIZONAL_PADDING, vertical = VERTICAL_PADDING)
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    painter = painterResource(com.iclickipayapplication.common.R.drawable.backarrow),
                    contentDescription = "Back",
                    modifier = Modifier
                        .clickable {
                            navController.popBackStack()
                        }
                        .size(30.dp),
                    tint = Color.White
                )
                Text(text = "Order", color = Color.White, fontSize = 25.sp)
                Text(
                    text = "Cancel",
                    color = Color.White,
                    modifier = Modifier.clickable {
                        navController.navigate("mechanic_home")
                    }
                )
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp)
                ) {
                    Image(
                        painter = painterResource(mechanic.mechanicPic),
                        contentDescription = "Mechanic Pic",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = "Handyman",
                        color = Color.White,
                        fontSize = 13.sp
                    )
                    Text(
                        text = mechanic.name,
                        color = Color.White
                    )
                }
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Date",
                    color = Color.White
                )
                Text(
                    text = "20 March, Thur - 14h",
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_location_on_24),
                    contentDescription = "Mechanic Pic",
                    modifier = Modifier
                        .size(30.dp),
                    tint = Color.White
                )
                Text(
                    text = mechanic.location,
                    color = Color.White
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(.6f)
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(horizontal = HORIZONAL_PADDING, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .drawBehind {
                        val y = size.height - borderThickness
                        drawLine(
                            color = Color.Gray,
                            start = Offset(0f, y),
                            end = Offset(size.width, y),
                            strokeWidth = borderThickness
                        )
                    }
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Mechanic")
                    Text(text = "Remove", color = orange, fontSize = 13.sp)
                }
                Column {
                    Text(text = mechanic.rate)
                    Text(text = "x3", color = orange, fontSize = 13.sp)
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .drawBehind {
                        val y = size.height - borderThickness
                        drawLine(
                            color = Color.Gray,
                            start = Offset(0f, y),
                            end = Offset(size.width, y),
                            strokeWidth = borderThickness
                        )
                    }
                    .padding(vertical = 10.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = "Subtotal")
                    Text(text = mechanic.rate)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = "Delivery fees")
                    Text(text = "$0.00", color = Color.Gray, fontSize = 13.sp )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(text = "Total amount", color = Color.Gray, fontSize = 13.sp)
                Text(text = "$ 45.00", color = orange, fontSize = 20.sp)
            }
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.Bottom
            ) {
                ButtonComponent(
                    text = "Place order",
                    onclick = {},
                    fillwidth = true
                )
            }
        }
    }
}