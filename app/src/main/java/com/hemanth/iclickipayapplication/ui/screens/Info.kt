package com.hemanth.iclickipayapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.hemanth.iclickipayapplication.R

@Composable
fun InfoScreen(){
    val contentHeader = remember { mutableStateOf("Bank & transfer") }
    val contentImage =  remember { mutableIntStateOf(R.drawable.group01) }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                Text(text = "Skip", color = colorResource(R.color.orange))
            }
            Column {
                Image(
                    painter = painterResource(id = contentImage.value),
                    contentDescription = "Image",
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }

    }


}