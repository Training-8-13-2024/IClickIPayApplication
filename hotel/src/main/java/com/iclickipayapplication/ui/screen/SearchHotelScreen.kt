package com.iclickipayapplication.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.hotel.R
import com.iclickipayapplication.ui.components.RoomPickerDialog
import com.iclickipayapplication.ui.components.SampleDatePickerView
import com.iclickipayapplication.ui.components.SearchCard
import java.time.LocalDate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchHotelScreen(
    navController: NavHostController? = null,
    lesson: String = "Leason", level: String? = "Level"
) {
    var location by remember { mutableStateOf("Johannesburg") }
    var checkInDate by remember { mutableStateOf(LocalDate.of(2024, 3, 20)) }
    var checkOutDate by remember { mutableStateOf(LocalDate.of(2024, 3, 22)) }
    var rooms by remember { mutableStateOf(1) }
    var adults by remember { mutableStateOf(2) }
    var showDatePicker by remember { mutableStateOf(false) }
    var showRoomDialog by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

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
                        .background(Color.White, shape = RoundedCornerShape(28.dp))
                        .padding(10.dp)
                        .clickable { },
                    painter = painterResource(id = R.drawable.icon_home_orange),
                    contentDescription = "Back"
                )
            }
        }
    ) { innerPa ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.image2),
                        contentDescription = "Header Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(500.dp),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .background(
                                Color.White.copy(alpha = 0.8f),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .align(Alignment.BottomCenter),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            Row(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "Johannesburg", fontWeight = FontWeight.Bold)

                            }
                            Row(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Places",
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Gray
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_places),
                                    contentDescription = "Arrow Down",
                                    tint = Color(0xFFFF6F00),
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = Modifier
                                    .clickable {
                                        showDatePicker = true
                                    },
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "CHOOSE DATES",
                                    modifier = Modifier
                                        .padding(15.dp)
                                )

                            }
                            Row(
                                modifier = Modifier
                                    .clickable {
                                        showRoomDialog = true
                                    },
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "NUMBERS OF ROOMS",
                                    modifier = Modifier
                                        .padding(15.dp)
                                )
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text("${checkInDate} - ${checkOutDate}", fontWeight = FontWeight.Bold)

                            Text("$level", fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            OutlinedTextField(
                                value = "",
                                onValueChange = {},
                                label = { Text("Search location / name country") },
                                trailingIcon = {
                                    Icon(
                                        Icons.Default.Search,
                                        contentDescription = "Search",
                                        tint = Color.Gray
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 16.dp),


                                )

                            Button(
                                onClick = { /* Handle search */ },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp)
                                    .padding(horizontal = 20.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFFF6F00),
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = "Search hotels", fontSize = 18.sp)
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFF6F00))
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.FavoriteBorder,
                            contentDescription = "Favorites",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Favorites", color = Color.White)
                    }
                    Row(
                        modifier = Modifier
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_order),
                            contentDescription = "Favorites",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Orders", color = Color.White)
                    }


                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {


                Text(
                    text = "Recommended Hotels",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = Color(0xFFFF6F00),
                    )
            }
                Spacer(modifier = Modifier.height(8.dp))
                SearchCard()
            }
        }

        var dateRangePickerState = rememberDateRangePickerState()

        Spacer(modifier = Modifier.padding(innerPa))
        // Date Picker Dialog
        if (showDatePicker) {

            SampleDatePickerView()
        }

        // Room and Adult Picker Dialog
        if (showRoomDialog) {
            RoomPickerDialog(
                rooms = rooms,
                adults = adults,
                onDismiss = { showRoomDialog = false },
                onConfirm = { selectedRooms, selectedAdults ->
                    rooms = selectedRooms
                    adults = selectedAdults
                    showRoomDialog = false
                }
            )
        }
    }
}


@Composable
@Preview
fun HotelScreen1Preview() {
    SearchHotelScreen()
}