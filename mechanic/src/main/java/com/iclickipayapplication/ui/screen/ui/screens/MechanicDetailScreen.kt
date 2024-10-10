package com.iclickipayapplication.ui.screen.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
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
fun MechanicDetailScreen(
    navController: NavHostController,
    mechanic: Mechanic
) {
    val orange = colorResource(ORANGE)
    val borderThickness = 1f
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = HORIZONAL_PADDING, vertical = VERTICAL_PADDING)
                .weight(.3f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(com.iclickipayapplication.common.R.drawable.backarrow),
                    contentDescription = "Back",
                    modifier = Modifier
                        .clickable {
                            navController.popBackStack()
                        }
                        .size(30.dp),
                    tint = orange
                )
            }
        }
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .weight(.7f)
                .background(color = Color.White)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(100.dp),
                ) {
                    Image(
                        painter = painterResource(mechanic.mechanicPic),
                        contentDescription = "Mechanic Pic",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = mechanic.name,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    fontSize = 20.sp,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = HORIZONAL_PADDING)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.location),
                            contentDescription = "Location",
                            tint = orange
                        )
                        Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                        Text(
                            text = mechanic.rating,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                    Text(
                        text = mechanic.rate,
                        modifier = Modifier.padding(end = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(vertical = 15.dp))
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
                        .padding(horizontal = HORIZONAL_PADDING, vertical = 10.dp)
                ) {
                    Text(
                        text = mechanic.about,
                        color = Color.Gray,
                    )
                }
                Spacer(modifier = Modifier.padding(vertical = 10.dp))
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
                        .padding(horizontal = HORIZONAL_PADDING, vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_location_on_24),
                        contentDescription = "Location",
                        tint = Color.Green
                    )
                    Text(
                        text = mechanic.location,
                        color = Color.Black,
                    )
                }
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
                        .padding(horizontal = HORIZONAL_PADDING, vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_settings_24),
                        contentDescription = "Phone",
                        tint = orange
                    )
                    Column() {
                        mechanic.specialization.forEach {
                            Text(
                                text = it,
                                color = Color.Black,
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = HORIZONAL_PADDING, vertical = 10.dp),
                    verticalAlignment = Alignment.Bottom,
                ) {
                    ButtonComponent(
                        text = "Take appointment",
                        onclick = {
                            navController.navigate("order/${mechanic.id}")
                        },
                        fillwidth = true
                    )
                }
            }
        }
    }
}