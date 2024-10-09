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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.learn.R
import com.iclickipayapplication.common.ui.components.CustomButton
import com.iclickipayapplication.data.getDummyTimeSlots
import com.iclickipayapplication.ui.LearnNavigationData
import com.iclickipayapplication.ui.components.CalendarHeader
import com.iclickipayapplication.ui.components.TimeSlotsList

@Composable
fun LearnBookingScreen(navController: NavHostController) {
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
                        .clickable { navController.navigate(LearnNavigationData.MAIN.name) },
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Back"
                )
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(10.dp),
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "Back"
                )
                Text(
                    text = "Jenny Jones",
                    fontSize = 24.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
    ){innerPadding ->
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Box(modifier = Modifier.height(300.dp)) {
                    CalendarHeader()
                }
                Spacer(modifier = Modifier.height(16.dp))
                Box(modifier = Modifier.height(340.dp)) {
                    TimeSlotsList(timeSlots = getDummyTimeSlots())
                }
                CustomButton(text = "Next", onClick = { navController.navigate(LearnNavigationData.ORDER.name) })
            }
        }

    }
}