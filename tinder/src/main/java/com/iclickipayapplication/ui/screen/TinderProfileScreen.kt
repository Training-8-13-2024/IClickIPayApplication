package com.iclickipayapplication.ui.screen

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.iclickipay.tinder.R
import com.iclickipayapplication.common.ui.components.CustomButton
import com.iclickipayapplication.ui.TinderNavigationData
import com.iclickipayapplication.viewmodel.TinderViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCompletionScreen(navController: NavHostController, viewModel: TinderViewModel = hiltViewModel()) {

    val booking by viewModel.upcomingData.observeAsState()
    val data = booking?.last()


    var description by remember { mutableStateOf(data?.description?:"Hello, I’m...") }
    var city by remember { mutableStateOf(data?.city?:"Dakar") }
    var dateOfBirth by remember { mutableStateOf(data?.dob?:"02/05/1976") }

    LaunchedEffect(data) {
        data?.let {
            description = it.description
            city = it.city
            dateOfBirth = it.dob
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
                        .clickable { navController.navigate(TinderNavigationData.SCREEN2.name) },
                    painter = painterResource(id = com.iclickipayapplication.common.R.drawable.backarrow),
                    contentDescription = "Back"
                )
                Text(
                    text = "Profile Completion",
                    fontSize = 24.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            TextField(
                value = description,
                onValueChange = { description = it },
                label = { Text(text = "Description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(8.dp)
            )

            TextField(
                value = city,
                onValueChange = { city = it },
                label = { Text(text = "City") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(8.dp)
            )

            TextField(
                value = dateOfBirth,
                onValueChange = { dateOfBirth = it },
                label = { Text(text = "Date of birth") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Add more photos", fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {

                Box(
                    modifier = Modifier
                        .height(280.dp)
                        .weight(1f)
                        .background(Color.LightGray, RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.photo1),
                        contentDescription = "Profile Picture",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                AddPhotoPlaceholder(Modifier.weight(1f))
                AddPhotoPlaceholder(Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.weight(1f))

            CustomButton(
                text = "Next",
                onClick = {
                    val updatedBooking = data?.copy(
                        description = description,
                        city = city,
                        dob = dateOfBirth
                    )
                    if (updatedBooking != null) {
                        viewModel.updateBooking(updatedBooking)
                    }
                    navController.navigate(TinderNavigationData.MAP.name)
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun AddPhotoPlaceholder(modifier: Modifier) {
    Box(
        modifier = modifier
            .height(280.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add Photo",
            tint = Color.Gray,
            modifier = Modifier.size(32.dp)
        )
    }
}