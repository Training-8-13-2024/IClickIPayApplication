package com.iclickipayapplication.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.iclickipay.data.model.tinder.ProductsModelItemModel
import com.iclickipay.tinder.R
import com.iclickipayapplication.ui.TinderNavigation
import com.iclickipayapplication.ui.TinderNavigationData

@Composable
fun TinderCard(color: Color, data: ProductsModelItemModel, navController: NavHostController){
        Card(
            modifier = Modifier
                .width(380.dp)
                .fillMaxHeight()
                .padding(10.dp),
            shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(color),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column {
                Image(
                    painter = rememberAsyncImagePainter(model =data.image),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .weight(0.8f)
                        .padding(16.dp)
                        .height(450.dp)
                        .clickable { navController.navigate(TinderNavigationData.DETAILS.name+"/${data.id}")},
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .weight(0.2f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${data.title}",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        text = "${data.price}",
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
                            contentDescription = "gallery"
                        )
                    }

                }

            }
        }

    }

@Composable
fun TinderImage(painter: Painter, onClick:()-> Unit) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(75.dp)
            .padding(2.dp)
            .clickable(onClick = onClick)
    )
}
