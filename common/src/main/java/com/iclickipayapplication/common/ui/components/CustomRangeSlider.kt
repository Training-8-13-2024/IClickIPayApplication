package com.iclickipayapplication.common.ui.components



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomRangeSlider() {

    var range by remember { mutableStateOf(1f..100f) }
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        // Title for the slider

        // RangeSlider for selecting range
        RangeSlider(
            value = range,
            onValueChange = { range = it },
            valueRange = 1f..600f,
            steps = 100,
            modifier = Modifier.fillMaxWidth(),
            startThumb = { thumbValue ->

                Text(
                    text = thumbValue.activeRangeStart.toInt().toString(),
                    color = Color.Black,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
                Surface(
                    modifier = Modifier.size(30.dp),
                    shape = CircleShape,
                    color = Color(0xFFFF6F00), // Orange thumb
                    shadowElevation = 4.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .background(Color.White, CircleShape) // Inner white circle
                        )
                    }
                }
            },endThumb = { thumbValue ->
                Text(
                    text = thumbValue.activeRangeEnd.toInt().toString(),
                    color = Color.Black,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
                Surface(
                    modifier = Modifier.size(30.dp),
                    shape = CircleShape,
                    color = Color(0xFFFF6F00), // Orange thumb
                    shadowElevation = 4.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .background(Color.White, CircleShape) // Inner white circle
                        )
                    }
                }
            },
            colors = SliderDefaults.colors(
                thumbColor = Color.Transparent, // Using custom thumb color
                activeTrackColor = Color.Transparent, // Orange active track
                inactiveTrackColor = Color.Transparent, // Light gray inactive track
                activeTickColor = Color(0xFFFF6F00), // Orange active tick
                inactiveTickColor = Color.LightGray
            )
        )

        // Show selected range
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = range.start.toInt().toString(), color = Color.Black) // Start value
            Text(text = range.endInclusive.toInt().toString(), color = Color.Black) // End value
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomRangeSlider() {
    CustomRangeSlider()
}



