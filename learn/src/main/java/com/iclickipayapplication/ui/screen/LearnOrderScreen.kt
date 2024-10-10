package com.iclickipayapplication.ui.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.iclickipay.learn.R
import com.iclickipayapplication.common.ui.components.CustomButton
import com.iclickipayapplication.ui.LearnNavigationData
import com.iclickipayapplication.viewModel.LearnTeacherViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LearnOrderScreen(navController: NavHostController, selectedDate: String, viewModel: LearnTeacherViewModel = hiltViewModel()){

    val booking by viewModel.upcomingData.observeAsState()
    val data = booking?.last()

    LaunchedEffect(data) {

    }
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(10.dp)
                        .clickable {navController.navigate(LearnNavigationData.BOOKING.name) },
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "Back"
                )
                Spacer(modifier = Modifier.size(30.dp))
                Text(
                    text = "Order",
                    fontSize = 24.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFFFE6F00))
                        .weight(0.5f)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color(0xFFFE6F00))
                            .padding(top =66.dp)
                    ){
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.image),
                                contentDescription = "Teacher Image",
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(
                                    text = "Teacher",
                                    fontSize = 12.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "Jenny Jones",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(18.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(text = "Start", fontSize = 12.sp, color = Color.White)
                                Text(text = "$selectedDate", fontSize = 16.sp, color = Color.White)
                            }
                            Column {
                                Text(text = "End", fontSize = 12.sp, color = Color.White)
                                Text(text = "$selectedDate", fontSize = 16.sp, color = Color.White)
                            }
                        }
                        Spacer(modifier = Modifier.height(18.dp))
                        Text(text = "28 Broad Street, Johannesburg", modifier = Modifier.padding(16.dp), color = Color.White)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier.weight(0.5f).padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "${data?.lesson} / ${data?.level}", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        Text(text = "$ ${data?.price}/h", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Remove", color = Color.Red, modifier = Modifier.clickable { /* Handle remove */ })
                        Text(text = "x1", fontSize = 16.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Subtotal", fontSize = 16.sp)
                        Text(text = "$ ${data?.price}", fontSize = 16.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Delivery fees", fontSize = 16.sp, color = Color.Gray)
                        Text(text = "$ 0.00", fontSize = 16.sp, color = Color.Gray)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Divider(color = Color.Gray, thickness = 1.dp)

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Total amount",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Text(
                            text = "$ ${data?.price}",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFA500)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))
                    CustomButton(text = "Place Order", onClick = {navController.navigate(LearnNavigationData.HOME.name) })

                }

            }
        }
    }
}

@Preview
@Composable
fun LearnOrderScreenPreview(){
    LearnOrderScreen(
        navController = NavHostController(LocalContext.current),
        selectedDate = "20 March, Thu - 15h",
        viewModel = hiltViewModel()
    )
}