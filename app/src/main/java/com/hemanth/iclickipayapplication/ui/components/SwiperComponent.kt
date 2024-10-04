package com.hemanth.iclickipayapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.hemanth.iclickipayapplication.R

@Composable
fun SwiperComponent(numPages: Int, currentPage: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
    ) {
        for (i in 0 until numPages) {
            val isSelected = i == currentPage

            Box(
                modifier = Modifier
                    .size(if (isSelected) 10.dp else 7.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) colorResource(R.color.orange) else Color(0xFFC4C4C4))
            ) {}
            Spacer(
                modifier = Modifier
                    .padding(horizontal = 3.dp)
            )
        }
    }
}