package com.iclickipayapplication.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.iclickipay.hotel.R
import com.iclickipayapplication.data.HotelModel
import com.iclickipayapplication.ui.HotelNavigation


@Composable
fun SearchCard(
    hotel: HotelModel,
    navController: NavHostController
     )
{
    Log.e("SearchCard", "navController: $navController")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Log.e("SearchCard", "Clicked on ${hotel.toString()}")
                    navController.navigate("${HotelNavigation.DETAIL.name}/${hotel.toString()}")
                }
                .background(Color.White)
        ) {
            Box {
                Image(
                    painter = painterResource(id = hotel.image),
                    contentDescription = hotel.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Favorite",
                        tint = Color.White,
                        modifier = Modifier
                            .size(50.dp)
                            .fillMaxWidth()
                            .padding(10.dp)
                            .background(Color.Transparent, shape = RoundedCornerShape(50))
                    )
                }
            }
           CardFooter(hotel)
        }
    }
}


//@Composable
//@Preview
//fun SearchCardPreview() {
//    SearchCard(
//        HotelModel(
//            name = "Hotel Name",
//            rating = 4.5,
//            distance = 25,
//            price = 10.0,
//            image = R.drawable.image2,
//            location = "Location"
//        ),
//        navController = NavHostController
//
//}