package com.iclickipayapplication.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TimeSlotsList(timeSlots: List<String>) {
    LazyColumn {
        items(timeSlots) { time ->
            TimeSlotItem(time = time)
        }
    }
}

@Composable
fun TimeSlotItem(time: String) {
    Text(
        text = time,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clickable { /* Handle time slot click */ },
        style = MaterialTheme.typography.titleLarge
    )
}