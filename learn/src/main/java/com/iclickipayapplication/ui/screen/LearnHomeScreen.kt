package com.iclickipayapplication.ui.screen

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.iclickipay.learn.R
import com.iclickipayapplication.ui.LearnNavigationData
import com.iclickipayapplication.ui.components.TeacherCard
import com.iclickipayapplication.viewModel.LearnTeacherViewModel
import com.iclickipayapplication.viewModel.TeacherAdapter
import dagger.hilt.android.lifecycle.HiltViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LearnHomeScreen (
    navController: NavHostController,
    viewModel: LearnTeacherViewModel = hiltViewModel()
) {
    val data by viewModel.upcomingData.observeAsState()

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
                        .clickable { navController.navigate(LearnNavigationData.SCREEN2.name)},
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Back"
                )
            }
        }
    ) {
//        val upcomingData = viewModel.upcomingData.value
        val booking = data?.last()
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.image),
                        contentDescription = "Header Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(500.dp),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .background(
                                Color.White.copy(alpha = 0.8f),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .align(Alignment.BottomCenter),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ){
                            Text(text = "Johannesburg, 1 Road Ubuntu", fontWeight = FontWeight.Bold)
                            Icon(painter = painterResource(id = R.drawable.location), contentDescription = "Location", modifier = Modifier
                                .size(30.dp)
                                .clickable { navController.navigate(LearnNavigationData.MAP.name) })
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text("CHOOSE DATE")
                            Text("LESSON")
                            Text("LEVEL")
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text("20 Mar - 10h", fontWeight = FontWeight.Bold)
                            Text("${booking?.lesson}", fontWeight = FontWeight.Bold)
                            Text("${booking?.level}", fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)) {
                            TextField(
                                value = "",
                                onValueChange = {},
                                label = { Text("Search location / name") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 16.dp)
                            )

                            Button(
                                onClick = { /* Handle search */ },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFFF6F00),
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = "Search", fontSize = 18.sp)
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFF6F00))
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(painter = painterResource(id = R.drawable.heart), contentDescription = "Favorites", tint = Color.White)
                    Icon(painter = painterResource(id = R.drawable.file), contentDescription = "Orders", tint = Color.White)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Text(text = "Teachers", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(start = 16.dp))
                    Spacer(modifier = Modifier.weight(1f))
                    Image(painterResource(id =  R.drawable.filter), contentDescription = "filter", modifier = Modifier.clickable { navController.navigate(
                        LearnNavigationData.FILTER.name) })
                }

                Spacer(modifier = Modifier.height(8.dp))
                TeacherCard(navController)
//                if (upcomingData.isEmpty()) {
//
//                }
//                else{
//                    LazyRow{
//                        items(upcomingData) {item -> TeacherCard(navController) }
//                    }
//                }


            }
        }

    }
}