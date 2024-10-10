package com.iclickipayapplication.ui.screen

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.iclickipay.data.learn.local.dao.TeacherBookingDao
import com.iclickipay.data.learn.local.entity.TeacherBookingEntity
import com.iclickipayapplication.common.local.AppDatabase
import com.iclickipayapplication.common.ui.components.CustomButton
import com.iclickipayapplication.ui.LearnNavigationData
import com.iclickipayapplication.ui.components.DropdownMenuField
import com.iclickipayapplication.viewModel.LearnTeacherViewModel

@Composable
fun LearnTeacherScreen(navController: NavHostController, viewModel: LearnTeacherViewModel = hiltViewModel()){
    val booking by viewModel.upcomingData.observeAsState()
    val data = booking?.last()

    var selectedLesson by remember { mutableStateOf(data?.lesson ?: "English") }
    var selectedLevel by remember { mutableStateOf(data?.level ?: "College") }
    var selectedTime by remember { mutableStateOf(data?.availabilityTime ?: 14f) }

    val lessons = listOf("English", "Math", "Science")
    val levels = listOf("College", "High School", "Middle School")
    val times = listOf(8, 11, 14, 17, 20)

    LaunchedEffect(data) {
        data?.let {
            selectedLesson = it.lesson
            selectedLevel = it.level
            selectedTime = it.availabilityTime
        }
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
                        .clickable { navController.navigate(LearnNavigationData.HOME.name)},
                    painter = painterResource(id = com.iclickipayapplication.common.R.drawable.backarrow),
                    contentDescription = "Back"
                )
                Text(
                    text = "Your Teacher",
                    fontSize = 24.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
    ){innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                DropdownMenuField("Lesson", lessons, selectedLesson) {
                    selectedLesson = it
                }

                Spacer(modifier = Modifier.height(24.dp))

                DropdownMenuField("Level", levels, selectedLevel) {
                    selectedLevel = it
                }

                Text(
                    text = "Availability",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    times.forEach { time ->
                        Text(
                            text = "${time}h",
                            fontSize = 16.sp,
                            color = if (time == selectedTime.toInt()) Color.Black else Color.Gray,
                            fontWeight = if (time == selectedTime.toInt()) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }

                Slider(
                    value = selectedTime,
                    onValueChange = { selectedTime = it },
                    valueRange = 8f..20f,
                    steps = 3,
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFFFF6F00),  // Custom color for the thumb
                        activeTrackColor = Color(0xFFFF6F00),  // Custom color for the active part of the track
                        inactiveTrackColor = Color(0xFF888888),  // Custom color for the inactive part of the track
                        activeTickColor = Color.Transparent,  // Custom color for the ticks in the active part
                        inactiveTickColor = Color.Transparent  // Custom color for the ticks in the inactive part
                    ),
                    onValueChangeFinished = { },
                )

                Spacer(modifier = Modifier.height(16.dp))

                Spacer(modifier = Modifier.weight(1f))

                CustomButton(
                    text = "Next",
                    onClick = {
                        val updatedBooking = data?.copy(
                            lesson = selectedLesson,
                            level = selectedLevel,
                            availabilityTime = selectedTime
                        )
                        if (updatedBooking != null) {
                            viewModel.insertBooking(updatedBooking)
                        }
                        navController.navigate(LearnNavigationData.MAIN.name)
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))
            }

        }
    }

}