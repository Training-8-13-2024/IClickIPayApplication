package com.iclickipayapplication.common.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipayapplication.common.R


@Composable
fun ButtonComponent(
    onclick: () -> Unit,
    text: String,
    width: Int = 250,
    fillwidth: Boolean = false,
    enabled: Boolean = true,
    height: Int = 50,
    buttonColor: Color = colorResource(R.color.orange)
) {
    Button(
        onClick = onclick,
        colors = ButtonColors(
            containerColor = buttonColor,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White
        ),
        enabled = enabled,
        shape = ShapeDefaults.ExtraSmall,
        modifier = Modifier
            .let { if (!fillwidth) it.padding(16.dp) else it }
            .height(height.dp)
            .let { if (fillwidth) it.fillMaxWidth() else it.width(width.dp) }
    ) {
        Text(text = text, fontSize = 17.sp)
    }
}