package com.iclickipayapplication.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.hotel.R
import com.iclickipayapplication.common.ui.components.CustomButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen() {


    Scaffold(
        topBar = {

            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFF7A1A),
                ),
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFFF7A1A)),
                        contentAlignment = androidx.compose.ui.Alignment.Center
                    ) {
                        Text(
                            text = "Order",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text("Cancel", color = Color.White)
                    }
                },
            )
        }
    ) { innerPadding ->


        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 30.dp)
                .verticalScroll(rememberScrollState())
        ) {


            // Hotel Info
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFF7A1A)),
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 30.dp, vertical = 40.dp)
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(text = "Hotel", color = White, fontSize = 14.sp)
                    Text(
                        text = "Ressort Hotel",
                        color = White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = "Check in", color = White, fontSize = 14.sp)
                            Text(text = "20 March, Thu", color = White, fontSize = 16.sp)
                        }
                        Text(
                            text = "2N",
                            color = White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .background(Green, shape = RoundedCornerShape(50))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                        Column {
                            Text(text = "Check out", color = White, fontSize = 14.sp)
                            Text(text = "22 March, Sat", color = White, fontSize = 16.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = "Room", color = White, fontSize = 14.sp)
                            Text(text = "1", color = White, fontSize = 16.sp)
                        }
                        Column {
                            Text(text = "Adults", color = White, fontSize = 14.sp)
                            Text(text = "2", color = White, fontSize = 16.sp)
                        }
                        Column {
                            Text(text = "Kids", color = White, fontSize = 14.sp)
                            Text(text = "1", color = White, fontSize = 16.sp)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Junior Suite
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(2f)) {
                    Text(text = "Junior suite", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Standard", fontSize = 14.sp, color = Gray)
                    Spacer(modifier = Modifier.height(4.dp))
                    TextButton(onClick = { /* Remove item action */ }) {
                        Text("Remove", color = Color(0xFFFF7A1A), fontSize = 14.sp)
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Pricing details
            Text(
                text = "Subtotal",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                color = Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$ 300.00",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF6F00),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Delivery fees",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                color = Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$ 2.50",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF6F00),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )

            Divider(
                color = LightGray,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            )

            // Total Amount
            Text(
                text = "Total amount",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                color = Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$ 302.50",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF6F00),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            CustomButton(text = "Place order", onClick = { /*TODO*/ })

            Spacer(modifier = Modifier
                .height(24.dp)
                .padding(innerPadding))
        }
    }
}