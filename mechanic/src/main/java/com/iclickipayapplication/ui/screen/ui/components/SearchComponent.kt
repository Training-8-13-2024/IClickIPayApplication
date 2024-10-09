package com.iclickipayapplication.ui.screen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.iclickipay.mechanic.R
import com.iclickipayapplication.common.constants.ORANGE
import com.iclickipayapplication.common.ui.components.ButtonComponent


@Composable
fun SearchComponent(
    location: String,
    date: String,
    carType: String,
    model: String
) {
    val orange = colorResource(ORANGE)
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.White)
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    val borderThickness = 1f
                    val y = size.height - borderThickness
                    drawLine(
                        color = Color.Gray,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = borderThickness
                    )
                }
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = location)
            Icon(
                painter = painterResource(R.drawable.location),
                contentDescription = "Search",
                tint = orange
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    val borderThickness = 1f
                    val y = size.height + borderThickness
                    drawLine(
                        color = Color.Gray,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = borderThickness
                    )
                }
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Choose Date", color = Color.Gray, fontWeight = FontWeight.Light)
                Spacer(modifier = Modifier.padding(vertical = 2.dp))
                Text(text = date)
            }
            Column {
                Text(text = "Type", color = Color.Gray, fontWeight = FontWeight.Light)
                Spacer(modifier = Modifier.padding(vertical = 2.dp))
                Text(text = carType)
            }
            Column {
                Text(text = "Model", color = Color.Gray, fontWeight = FontWeight.Light)
                Spacer(modifier = Modifier.padding(vertical = 2.dp))
                Text(text = model)
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        ButtonComponent(
            text = "Search",
            onclick = {},
            fillwidth = true,
            height = 40
        )
    }
}