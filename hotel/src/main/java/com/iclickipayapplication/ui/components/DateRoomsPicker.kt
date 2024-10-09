package com.iclickipayapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.hotel.R
import java.time.LocalDate


@Composable
fun DateRoomsPicker(
    checkInDate: LocalDate,
    checkOutDate: LocalDate,
    rooms: Int,
    onShowDatePickerChange: (Boolean) -> Unit,
    onShowRoomPickerChange: (Boolean) -> Unit,
) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Johannesburg", fontWeight = FontWeight.Bold)

            }
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Places",
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.icon_places),
                    contentDescription = "Arrow Down",
                    tint = Color(0xFFFF6F00),
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .drawBorderOnSides(
                borderColor = Color.LightGray,
                borderWidth = 2.dp,
                sides = listOf(BorderSide.BOTTOM, BorderSide.TOP)
            )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        onShowDatePickerChange(true)
                    },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "CHOOSE DATES",
                    modifier = Modifier
                        .padding(15.dp)
                )
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text("$checkInDate - $checkOutDate", fontWeight = FontWeight.Bold)

                    Text(text = rooms.toString(), fontWeight = FontWeight.Bold)
                }
            }
Box(
    modifier = Modifier
        .height(100.dp).
        width(1.dp)
        .drawBorderOnSides(
            borderColor = Color.LightGray,
            borderWidth = 2.dp,
            sides = listOf(BorderSide.LEFT)
        ),
)
            Column(
                modifier = Modifier
                    .clickable {
                        onShowRoomPickerChange(true)
                    }
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "NUMBERS OF ROOMS",
                    modifier = Modifier
                        .padding(15.dp)
                )
                Text(text = rooms.toString(), fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Search location / name country") },
                trailingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),


                )

            Button(
                onClick = { /* Handle search */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6F00),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Search hotels", fontSize = 18.sp)
            }
        }
//    }
}



@Composable
@Preview
fun DateRoomsPickerPreview() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
    ) {
        DateRoomsPicker(
            checkInDate = LocalDate.now(),
            checkOutDate = LocalDate.now().plusDays(1),
            rooms = 1,
            onShowDatePickerChange = {},
            onShowRoomPickerChange = {}
        )
    }
}

enum class BorderSide {
    TOP, BOTTOM, LEFT, RIGHT
}







fun Modifier.drawBorderOnSides(borderColor: Color, borderWidth: Dp, sides: List<BorderSide>) = this.then(
    Modifier.drawBehind {
        val strokeWidthPx = borderWidth.toPx()

        // Draw the borders on the specified sides
        sides.forEach { side ->
            when (side) {
                BorderSide.TOP -> {
                    drawLine(
                        color = borderColor,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = strokeWidthPx
                    )
                }
                BorderSide.BOTTOM -> {
                    drawLine(
                        color = borderColor,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = strokeWidthPx
                    )
                }
                BorderSide.LEFT -> {
                    drawLine(
                        color = borderColor,
                        start = Offset(0f, 0f),
                        end = Offset(0f, size.height),
                        strokeWidth = strokeWidthPx
                    )
                }
                BorderSide.RIGHT -> {
                    drawLine(
                        color = borderColor,
                        start = Offset(size.width, 0f),
                        end = Offset(size.width, size.height),
                        strokeWidth = strokeWidthPx
                    )
                }
            }
        }
    }
)