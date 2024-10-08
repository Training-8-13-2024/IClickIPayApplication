package com.iclickipayapplication.ui.screen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipayapplication.ui.screen.data.models.Dummy


@Composable
fun SliderComponent(
    sliders: List<Dummy>,
    selectedIndex: Int,
    onClick: (Int) -> Unit
) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    )
    {
        items(sliders.size) { item ->
            SliderItem(item = sliders[item],
                selected = item == selectedIndex,
                onClick = { onClick(item) }
            )
        }
    }
}

@Composable
fun SliderItem(
    item: Dummy,
    onClick: () -> Unit,
    selected: Boolean = false
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.height(144.dp)
            .width(150.dp)
            .clickable {
                onClick()
            }
            .clip(shape = RoundedCornerShape(10.dp))
            .then(
                if (selected) Modifier.background(Color(0xFF1140C9)) else Modifier.background(Color(0xFFF0F1F4))
            )
    ) {
        Image(
            painter = painterResource(id = item.userImage),
            contentDescription = "profile",
            modifier = Modifier.size(40.dp)
        )
        Text(text = item.ReceipientName, maxLines = 1, fontSize =12.sp, color = if(selected) Color.White else Color(0xFFA6AAB4))
    }
}