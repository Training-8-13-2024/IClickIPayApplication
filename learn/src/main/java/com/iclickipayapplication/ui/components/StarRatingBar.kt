package com.iclickipayapplication.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.iclickipay.learn.R

@Composable
fun StarRatingBar(
    selectedRating: Float,
    onRatingSelected: (Float) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..5) {
            Icon(
                painter = painterResource(id = if (i <= selectedRating) R.drawable.starfilled else R.drawable.staroutlined),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        onRatingSelected(i.toFloat())
                    },
                tint = if (i <= selectedRating) Color(0xFFFFA726) else Color.LightGray
            )
        }
    }
}