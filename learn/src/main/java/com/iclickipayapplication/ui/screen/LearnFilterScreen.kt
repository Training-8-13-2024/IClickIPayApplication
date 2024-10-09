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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.iclickipayapplication.ui.LearnNavigationData
import com.iclickipayapplication.ui.components.DropdownMenuField
import com.iclickipayapplication.ui.components.StarRatingBar

@Composable
fun LearnFilterScreen(navController: NavHostController){

    var selectedSortOption by remember { mutableStateOf("Recommend") }
    val sortOptions = listOf("Recommend", "Price: Low to High", "Price: High to Low")


    var sliderPosition by remember { mutableStateOf(30f) }
    var selectedRating by remember { mutableStateOf(3.5f) }

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
                        .clickable { },
                    painter = painterResource(id = com.iclickipayapplication.common.R.drawable.backarrow),
                    contentDescription = "Back"
                )
                Spacer(modifier = Modifier.size(30.dp))
                Text(
                    text = "Filters",
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
                DropdownMenuField(label ="Sort by" , options = sortOptions, selectedOption = selectedSortOption) {
                    selectedSortOption = it
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(text = "Price/hour", style = MaterialTheme.typography.titleMedium)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "0", color = Color.Gray)
                    Text(text = sliderPosition.toInt().toString(), color = Color.Gray)
                }
                Slider(
                    value = sliderPosition,
                    onValueChange = { sliderPosition = it },
                    valueRange = 0f..60f,
                    steps = 5,
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFFFFA726),
                        activeTrackColor = Color(0xFFFFA726)
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(text = "Rate", style = MaterialTheme.typography.titleMedium)
                StarRatingBar(selectedRating = selectedRating) { selectedRating = it }

                Spacer(modifier = Modifier.height(48.dp))

                CustomButton(text = "Apply", onClick = { navController.navigate(LearnNavigationData.MAIN.name) })
            }
        }

    }

}