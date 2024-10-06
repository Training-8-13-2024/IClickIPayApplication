package com.iclickipayapplication.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.tinder.R
import com.iclickipayapplication.common.ui.components.CustomButton
import com.iclickipayapplication.ui.TinderNavigationData

@Composable
fun TinderScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(10.dp)
                        .clickable { },
                    painter = painterResource(id = com.iclickipayapplication.common.R.drawable.backarrow),
                    contentDescription = "Back"
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.TopStart
                ) {
                    val image: Painter = painterResource(id = R.drawable.tinderhome)
                    Image(
                        painter = image,
                        contentDescription = "Meet Illustration",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                }

                Spacer(modifier = Modifier.height(156.dp))


                Text(
                    text = "Meet",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF333333)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis sit amet odio in egestas. Pellen tesque ultricies justo.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF888888),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.weight(0.5f))


                CustomButton(
                    text = "Let's go",
                    onClick = {
                        navController.navigate(TinderNavigationData.SCREEN2.name)
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }

}