package com.iclickipayapplication.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.tinder.R
import com.iclickipayapplication.ui.TinderNavigationData

@Composable
fun TinderMainScreen(navController: NavHostController) {
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
                        .weight(1f)
                        .padding(10.dp)
                        .clickable { navController.navigate(TinderNavigationData.TUTORIAL.name)  },
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Back"
                )
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .weight(1f)
                        .padding(10.dp)
                        .clickable {  },
                    painter = painterResource(id = R.drawable.msg),
                    contentDescription = "Back"
                )
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .weight(1f)
                        .padding(10.dp)
                        .clickable { navController.navigate(TinderNavigationData.PROFILE.name)  },
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Back"
                )
            }
        }
    ){ innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(0.8f),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.tindermeet),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .height(500.dp)
                                .clickable {  },
                            contentScale = ContentScale.Crop
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Emily, ",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(end = 4.dp)
                            )
                            Text(
                                text = "23",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Gray
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Image(
                                    modifier = Modifier
                                        .size(50.dp)
                                        .padding(10.dp),
                                    painter = painterResource(id = R.drawable.gellary),
                                    contentDescription = "Back"
                                )
                            }

                        }

                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth().weight(0.2f),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    TinderImage(painter = painterResource(id = R.drawable.rereturn))
                    TinderImage(painter = painterResource(id = R.drawable.cancel))
                    TinderImage(painter = painterResource(id = R.drawable.fire))
                    TinderImage(painter = painterResource(id = R.drawable.love))
                    TinderImage(painter = painterResource(id = R.drawable.stars))
                }

            }
        }
    }

}

@Composable
fun TinderImage(painter: Painter) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(75.dp)
            .padding(2.dp)
    )
}