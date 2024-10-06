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
fun TinderTutorialScreen(navController: NavHostController) {
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
                        .clickable { navController.navigate(TinderNavigationData.MAP.name)  },
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
                    val image: Painter = painterResource(id = R.drawable.tutorial)
                    Image(
                        painter = image,
                        contentDescription = "Meet Illustration",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))


                Text(
                    text = "Tutorial",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF333333)
                )

                Spacer(modifier = Modifier.height(18.dp))
                TutorialItem(
                    iconResId = R.drawable.player_fast_back,
                    title = "Return to profile",
                    description = ""
                )
                Spacer(modifier = Modifier.height(12.dp))
                TutorialItem(
                    iconResId = R.drawable.cross,
                    title = "No favorite. The profile will not appear.",
                    description = ""
                )
                Spacer(modifier = Modifier.height(12.dp))
                TutorialItem(
                    iconResId = R.drawable.heart,
                    title = "Like. If it's mutual, you can talk together (5 per day)",
                    description = ""
                )
                Spacer(modifier = Modifier.height(12.dp))
                TutorialItem(
                    iconResId = R.drawable.star,
                    title = "Super like. Indicate visually that you are interested (1 per day)",
                    description = ""
                )
                Spacer(modifier = Modifier.height(12.dp))
                TutorialItem(
                    iconResId = R.drawable.icon_2,
                    title = "Boost. Be top profile during 30 minutes.",
                    description = ""
                )

                Spacer(modifier = Modifier.weight(0.5f))


                CustomButton(
                    text = "Discover the Profile",
                    onClick = {
                        navController.navigate(TinderNavigationData.MAIN.name)
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }

}