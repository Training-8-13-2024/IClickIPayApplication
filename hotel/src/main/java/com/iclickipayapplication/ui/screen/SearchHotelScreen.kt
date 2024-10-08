package com.iclickipayapplication.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.iclickipay.hotel.R


@Composable
fun SearchHotelScreen(
    navController: NavHostController? = null
) {

    Scaffold(topBar = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(vertical = 20.dp, horizontal = 10.dp),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.padding(20.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(45.dp)
                        .background(
                            Color.White, shape = androidx.compose.foundation.shape.CircleShape
                        )
                        .padding(12.dp)
                        .clickable { navController?.popBackStack() },
                    painter = painterResource(id = R.drawable.icon_home_orange),
                    contentDescription = "Back",

                    )
            }
        }
    }) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(364.dp),
                    painter = painterResource(id = R.drawable.image2),
                    contentDescription = "Bed head",
                    contentScale = androidx.compose.ui.layout.ContentScale.FillWidth
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                ) {
                        Row {
                        }
                }
            }
        }
    }
}

@Composable
@Preview
fun HotelScreen1Preview() {
    SearchHotelScreen()
}