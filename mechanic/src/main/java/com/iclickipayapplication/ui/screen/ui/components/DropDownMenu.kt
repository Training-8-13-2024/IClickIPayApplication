package com.iclickipayapplication.ui.screen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.mechanic.R

@Composable
fun DropDownMenu(
    items: List<String>,
    onItemSelected: (String) -> Unit,
    label: String,
    selectedItem: String
) {
    val leadingIcon = remember { mutableIntStateOf(R.drawable.baseline_arrow_drop_down_24) }
    val expanded = remember { mutableStateOf(false) }
    Column() {
        Text(text = label)
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        InputComponentMechanic(
            inputName = "Select",
            value = selectedItem,
            onItemSelected,
            leadingIcon = {
                Icon(
                    painter = painterResource(leadingIcon.value),
                    contentDescription = "Drop Down Menu Icon",
                )
            },
            onItemClick = {
                expanded.value = !expanded.value
            }
        )
        if (expanded.value) {
            Column(
                modifier = Modifier
                    .shadow(
                        elevation = 2.dp,
                        spotColor = Color.Black,
                        ambientColor = Color.Black
                    )
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                items.forEach { item ->
                    DropDownMenuItem(
                        item = item,
                        onItemSelected = {
                            expanded.value = false
                            onItemSelected(it)
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
    }
}

@Composable
fun DropDownMenuItem(
    item: String,
    onItemSelected: (String) -> Unit
) {
    Text(
        text = item,
        color = Color.Black,
        fontSize = 15.sp,
        modifier = Modifier
            .wrapContentSize()
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onItemSelected(item)
            }
    )
}