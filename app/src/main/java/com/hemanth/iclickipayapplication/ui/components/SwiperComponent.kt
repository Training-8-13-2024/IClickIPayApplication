package com.hemanth.iclickipayapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.hemanth.iclickipayapplication.R

@Composable
fun SwiperComponent(numPages: Int, currentPage: Int, onPageSelected: (Int) -> Unit) {
    val activeIndex = remember { mutableIntStateOf(currentPage) }
    Row {
        for (i in 0 until numPages) {
            val isSelected = i == activeIndex.value
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .padding(end = 4.dp)
                    .background(if (isSelected) colorResource(R.color.orange) else colorResource(R.color.grey))
            ) {

            }
        }
    }
}