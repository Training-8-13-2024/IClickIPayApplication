package com.iclickipay.iclickipayapplication.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.iclickipayapplication.R
import kotlin.math.round

@Composable
fun ButtonComponent(
    onclick: () -> Unit,
    text: String,
){
    Button(
        onClick = onclick,
        colors = ButtonColors(
            containerColor = colorResource(R.color.orange),
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White
        ),
        shape = ShapeDefaults.ExtraSmall,
        modifier = Modifier
            .padding(16.dp)
            .width(200.dp)
            .height(50.dp)
    ){
        Text(text = text, fontSize = 17.sp)
    }
}