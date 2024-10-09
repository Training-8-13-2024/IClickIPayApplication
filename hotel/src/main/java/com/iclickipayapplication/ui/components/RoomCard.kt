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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun RoomCard(
    rooms: Int,
    adults: Int,
    kids: Int,
    onAdultsChange: (Int) -> Unit,
    onKidsChange: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .width(250.dp)
            .height(150.dp)
            .background(Color(0xFF10C971), MaterialTheme.shapes.small),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Rooms ${rooms+1}",
            color = Color.White,
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = "Adults", color = Color.White)
                    Spacer(modifier = Modifier.width(4.dp))

                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .width(20.dp)
                            .clickable{
                                onAdultsChange(adults - 1)
                            }
                            .background(
                                Color.Transparent,
                                MaterialTheme.shapes.small
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "-",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge,
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .background(Color.White, MaterialTheme.shapes.small)
                    ) {
                        Text(
                            text = "$adults",
                            color = Color.Black,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .width(20.dp)
                            .clickable {
                                onAdultsChange(adults + 1)
                            }
                            .background(
                                Color.Transparent,
                                MaterialTheme.shapes.small
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "+",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge,
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = "Kids", color = Color.White)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Included",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.White
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .width(20.dp)
                            .clickable{
                                onAdultsChange(kids - 1)
                            }
                            .background(
                                Color.Transparent,
                                MaterialTheme.shapes.small
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "-",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge,
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .background(Color.White, MaterialTheme.shapes.small)
                    ) {
                        Text(
                            text = "$kids",
                            color = Color.Black,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .width(20.dp)
                            .clickable{
                                onKidsChange(kids + 1)
                            }
                            .background(
                                Color.Transparent,
                                MaterialTheme.shapes.small
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "+",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge,
                        )
                    }
                }
            }
        }
    }
}