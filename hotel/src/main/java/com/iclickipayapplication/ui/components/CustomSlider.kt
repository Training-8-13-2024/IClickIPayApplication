package com.iclickipayapplication.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomSlider() {
    var priceRange by remember { mutableStateOf(300f) }

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        // Price slider
        Text(text = "Price", fontSize = 16.sp)

        Slider(
            value = priceRange,
            onValueChange = { priceRange = it },
            valueRange = 0f..600f,
            modifier = Modifier.fillMaxWidth(),
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFFFF6D00), // Orange color for the thumb
                activeTrackColor = Color(0xFFFF6D00), // Orange active track
                inactiveTrackColor = Color.LightGray // Light gray for inactive track
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "0", color = Color.Black) // Black color for labels
            Text(text = priceRange.toInt().toString(), color = Color.Black)
            Text(text = "600", color = Color.LightGray) // Light gray for max value
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomSlider() {
    CustomSlider()
}