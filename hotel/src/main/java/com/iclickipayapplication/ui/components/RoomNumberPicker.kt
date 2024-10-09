package com.iclickipayapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun RoomPickerDialog(rooms: Int, adults: Int, onDismiss: () -> Unit, onConfirm: (rooms: Int, adults: Int) -> Unit) {
    var tempRooms by remember { mutableStateOf(rooms) }
    var tempAdults by remember { mutableStateOf(adults) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Select Rooms & Adults", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(8.dp))

                Spacer(modifier = Modifier.height(16.dp))

                // Rooms Selection
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Rooms")
                    Row {
                        Button(onClick = { if (tempRooms > 1) tempRooms-- }) {
                            Text(text = "-")
                        }
                        Text(
                            text = "$tempRooms",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Button(onClick = { tempRooms++ }) {
                            Text(text = "+")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Adults Selection
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Adults")
                    Row {
                        Button(onClick = { if (tempAdults > 1) tempAdults-- }) {
                            Text(text = "-")
                        }
                        Text(
                            text = "$tempAdults",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Button(onClick = { tempAdults++ }) {
                            Text(text = "+")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row {
                    Button(onClick = { onConfirm(tempRooms, tempAdults) }) {
                        Text(text = "Confirm")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = onDismiss) {
                        Text(text = "Cancel")
                    }
                }
            }
        }
    }
}