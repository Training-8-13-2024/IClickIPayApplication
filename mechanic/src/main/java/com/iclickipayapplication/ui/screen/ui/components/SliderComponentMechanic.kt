package com.iclickipayapplication.ui.screen.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SliderComponent(
    values: List<Int>,
    sliderValue: Int,
    onValueChange: (Float) -> Unit
){

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        values.forEach { value ->
                Text(
                    text = "${value}h",
                    color = if (sliderValue == value) Color.Black else Color.Gray
                )
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
    Slider(
        value = values.indexOf(sliderValue).toFloat(),
        onValueChange = { it -> onValueChange(it) },
        valueRange = 0f .. (values.size - 1).toFloat(),
    )
}