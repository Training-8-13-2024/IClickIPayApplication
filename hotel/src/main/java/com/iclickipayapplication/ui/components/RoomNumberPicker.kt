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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.iclickipayapplication.common.ui.components.CustomButton

@Composable
fun RoomPickerDialog(
    rooms: MutableState<Int>,
    adults: MutableState<Int>,
    kids: MutableState<Int>,
    onDismiss: () -> Unit,
    onConfirm: (rooms: Int, kids: Int, adults: Int) -> Unit,
    onClose: () -> Unit
) {

    Box(
        modifier = Modifier.background(Color.White),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Numbers of rooms",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(8.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

//                Rooms, Adults, Kids
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Column(
                            modifier = Modifier.padding(10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Rooms", color = Color(0xFFFF7A1A))
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "${rooms.value}")
                        }
                    }
                    Row {
                        Column(
                            modifier = Modifier.padding(10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Adults", color = Color(0xFFFF7A1A))
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "${adults.value}")
                        }
                    }
                    Row {
                        Column(
                            modifier = Modifier.padding(10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Kids", color = Color(0xFFFF7A1A))
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "${kids.value}")
                        }
                    }
                }

//
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Numbers of persons",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(rooms.value) { item ->

                        RoomCard(
                            rooms = item,
                            adults = adults.value,
                            kids = kids.value,
                            onAdultsChange = { new ->
                                adults.value = new
                            },
                            onKidsChange = { new ->
                                kids.value = new
                            }
                        )
                    }

                    // Rooms Selection


                    item {
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(
                            modifier = Modifier
                                .padding(0.dp)
                                .width(250.dp)
                                .clickable{
                                    rooms.value += 1
                                }
                                .height(150.dp)
                                .background(
                                    Color(0xFFF9FAFB),
                                    MaterialTheme.shapes.large
                                )
                                .drawBehind {
                                    // Convert Dp to Px
                                    val strokeWidth = 2.dp.toPx()
                                    val dash = 10.dp.toPx()
                                    val gap = 10.dp.toPx()

                                    // Define the stroke style with a dashed effect
                                    val paint = Stroke(
                                        width = strokeWidth,
                                        pathEffect = PathEffect.dashPathEffect(
                                            floatArrayOf(dash, gap), 0f
                                        ),
                                        cap = StrokeCap.Round
                                    )

                                    // Get the size of the canvas
                                    val width = size.width
                                    val height = size.height

                                    // Draw dashed border with rounded corners
                                    drawRoundRect(
                                        color = Color(0xFFD6D9E4),
                                        topLeft = Offset(0f, 0f),
                                        size = size,
                                        style = paint,
                                        cornerRadius = androidx.compose.ui.geometry.CornerRadius(
                                            16.dp.toPx(),
                                            16.dp.toPx()
                                        )
                                    )
                                },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .background(Color(0xFF10C971), MaterialTheme.shapes.extraLarge)
                            ) {
                                Icon(
                                    Icons.Default.Add,
                                    contentDescription = "Add Button",
                                    tint = Color.White,
                                    modifier = Modifier.padding(10.dp)
                                )

                            }
                            Column(
                                modifier = Modifier.padding(10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Add",
                                    color = Color.DarkGray,
                                    style = MaterialTheme.typography.labelMedium
                                )
                                Text(
                                    text = "New Room",
                                    color = Color.DarkGray,
                                    style = MaterialTheme.typography.labelMedium
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(15.dp))
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp)
                ) {
                    CustomButton(text = "Submit", onClick = {
                        onConfirm(rooms.value, kids.value, adults.value)
                        onClose()
                    })
                }
            }
        }
    }
}


//@Composable
//@Preview
//fun RoomPickerDialogPreview() {
//    RoomPickerDialog(
//        rooms = mutableStateOf(1),
//        adults = mutableStateOf(1),
//        kids = mutableStateOf(1),
//        onDismiss = { },
//        onConfirm = { rooms, kids, adults -> }
//    )
//}