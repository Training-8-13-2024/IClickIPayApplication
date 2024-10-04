package com.hemanth.iclickipayapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hemanth.iclickipayapplication.R
import com.hemanth.iclickipayapplication.ui.components.SwiperComponent

@Composable
fun InfoScreen() {
    val contentHeader = remember { mutableStateOf("Bank & transfer") }
    val contentImage = remember { mutableIntStateOf(R.drawable.group01) }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                Text(text = "Skip", color = colorResource(R.color.orange))
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = contentImage.value),
                    contentDescription = "Image",
                    modifier = Modifier
                        .size(350.dp)
                )
                Text(
                    text = contentHeader.value,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis sit amet odio in egestas. Pellen tesque ultricies justo.",
                    fontSize = 18.sp,
                    color = colorResource(R.color.grey),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                )
                SwiperComponent(4,0,{})
            }
        }

    }


}