package com.iclickipayapplication.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.hotel.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HotelDetailScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){
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
    ){innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.image2),
                        contentDescription = "Header Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            ModalBottomSheet(onDismissRequest = { /*TODO*/ }) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ){
                    Column(
                        modifier = Modifier.padding(16.dp)
                    )
                    {
                        Text(
                            text = "Ressort Hotel",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Johannesburg",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
                    ){
                        EquipmentItem(icon = R.drawable.star, label = "4.8")
                        EquipmentItem(icon = R.drawable.route, label = "500 m to Center")
                        EquipmentItem(icon = R.drawable.moon, label = "$ 150")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ){
                        Image(
                            painterResource(id =R.drawable.map ),
                            contentDescription = "map",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        EquipmentItem(icon = R.drawable.pin, label = "28 Orchard Road Johannesburg")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "0.7 miles",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 22.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Column (modifier = Modifier.padding(16.dp)){
                        Text(
                            text = "Transport",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
                    ){
                        EquipmentItem(icon = R.drawable.star, label = "4.8")
                        EquipmentItem(icon = R.drawable.route, label = "500 m to Center")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
                    ){
                        EquipmentItem(icon = R.drawable.star, label = "4.8")
                        EquipmentItem(icon = R.drawable.route, label = "500 m to Center")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
                    ){
                        EquipmentItem(icon = R.drawable.star, label = "4.8")
                        EquipmentItem(icon = R.drawable.route, label = "500 m to Center")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Column (modifier = Modifier.padding(16.dp)){
                        Text(
                            text = "Equipements",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
                    ){
                        EquipmentItem(icon = R.drawable.star, label = "4.8")
                        EquipmentItem(icon = R.drawable.route, label = "500 m to Center")
                        EquipmentItem(icon = R.drawable.route, label = "500 m to Center")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
                    ){
                        EquipmentItem(icon = R.drawable.star, label = "4.8")
                        EquipmentItem(icon = R.drawable.route, label = "500 m to Center")
                        EquipmentItem(icon = R.drawable.route, label = "500 m to Center")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
                    ){
                        EquipmentItem(icon = R.drawable.star, label = "4.8")
                        EquipmentItem(icon = R.drawable.route, label = "500 m to Center")
                        EquipmentItem(icon = R.drawable.route, label = "500 m to Center")
                    }
                }
            }
        }
    }
}
@Composable
fun EquipmentItem(icon: Int, label: String) {
    Row(
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = label,
            modifier = Modifier
                .size(22.dp)
                .padding(3.dp)
        )
        Text(text = label, fontSize = 14.sp)
    }
}