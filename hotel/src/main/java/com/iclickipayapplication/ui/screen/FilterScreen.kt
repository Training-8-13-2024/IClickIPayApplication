package com.iclickipayapplication.ui.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.hotel.R
import com.iclickipayapplication.common.ui.components.CustomButton
import com.iclickipayapplication.common.ui.components.CustomRangeSlider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(
    onBack: () -> Unit? = {}
) {
    var range = remember { mutableStateOf(1f..600f) }

//    var selectedRating by remember { mutableStateOf(3f) } // Default rating is 3.5
    var priceRange by remember { mutableStateOf(300f) }
    var selectedRating by remember { mutableStateOf(3.5f) }
    val equipmentOptions =
        listOf("Restaurant", "Tennis", "Bar", "Wifi", "Parking", "Golf", "Pool", "Handy", "Spa")
    val checkedOptions = remember {
        mutableStateMapOf<String, Boolean>().apply {
            equipmentOptions.forEach {
                put(
                    it,
                    false
                )
            }
        }
    }
    checkedOptions["Tennis"] = true

    Scaffold(
        topBar =
        {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    onBack()
                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
                Spacer(Modifier.weight(1f))
                Text(
                    text = "Filters",
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                )
                Spacer(Modifier.weight(1f))
                ClickableText(
                    text = AnnotatedString("Clear"),
                    onClick = { /* Clear action */ },
                    style = TextStyle(color = Color(0xFFFF6D00))
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {


            // Price slider
            Text(text = "Price", fontSize = 16.sp)
            // Custom range slider
            CustomRangeSlider()


            Spacer(modifier = Modifier.height(16.dp))

            // Rating bar (using stars)
            Text(text = "Rate", fontSize = 16.sp)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(5) { index ->
                    val ratingValue = index + 1f

                    Icon(
                        painter = painterResource(
                            id = if (index < selectedRating.toInt()) R.drawable.icon_full_star
                            else if (index < selectedRating) R.drawable.icon_half_star
                            else R.drawable.icon_start
                        ),
                        contentDescription = "Star",
                        tint = Color(0xFFFF6D00),
                        modifier = Modifier
                            .size(32.dp)
                            .clickable {
                                Log.w("FilterScreen", "Rating clicked: $ratingValue")
                                selectedRating = ratingValue
                            }
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Equipments list with checkboxes
            Text(text = "Equipments", fontSize = 16.sp)
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                equipmentOptions.chunked(2).forEach { rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        rowItems.forEach { option ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = checkedOptions[option] ?: false,
                                        onCheckedChange = { isChecked ->
                                            checkedOptions[option] = isChecked
                                        },
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = Color(
                                                0xFFFF6D00
                                            )
                                        )
                                    )

                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = option)
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Apply button
            CustomButton(
                text = "Apply",
                onClick = {

                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFilterScreen() {
    FilterScreen()
}