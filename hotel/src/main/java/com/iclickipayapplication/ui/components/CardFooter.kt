package com.iclickipayapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.hotel.R
import com.iclickipayapplication.data.HotelModel


@Composable
fun CardFooter(hotel: HotelModel) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = hotel.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = hotel.location, fontWeight = FontWeight.Normal, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(Color.Gray),
        ) {

        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = "Rating",
                    tint = Color(0xFFFF7A1A),
                    modifier = Modifier.size(15.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = hotel.rating.toString(),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource(id = R.drawable.icon_distance),
                    contentDescription = "Distance",
                    tint = Color.LightGray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${hotel.distance}km to center",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }
            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            )
            {
                Icon(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource(id = R.drawable.icon_night),
                    contentDescription = "per night",
                    tint = Color.LightGray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "\$ ${hotel.price}",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}