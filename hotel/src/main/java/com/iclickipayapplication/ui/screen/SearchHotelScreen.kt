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
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.hotel.R
import com.iclickipayapplication.data.HotelModel
import com.iclickipayapplication.ui.components.DateRoomsPicker
import com.iclickipayapplication.ui.components.RoomPickerDialog
import com.iclickipayapplication.ui.components.HotelDatePicker
import com.iclickipayapplication.ui.components.SearchCard
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchHotelScreen(
    navController: NavHostController? = null,
    lesson: String = "Leason", level: String? = "Level"
) {


    var location by remember { mutableStateOf("Johannesburg") }
//    var checkInDate by remember { mutableStateOf(LocalDate.of(2024, 3, 20)) }
//    var checkOutDate by remember { mutableStateOf(LocalDate.of(2024, 3, 22)) }

    var rooms = remember { mutableStateOf(1) }
    var adults = remember { mutableStateOf(1) }
    var kids = remember { mutableStateOf(0) }

    var checkInDate = remember { mutableStateOf(LocalDate.of(2024, 3, 20)) }
    var checkOutDate = remember { mutableStateOf(LocalDate.of(2024, 3, 22)) }

    var showDatePicker by remember { mutableStateOf(false) }
    var showRoomDialog by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    val hotelImages = listOf(
        R.drawable.image,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
    )

    val hotelList = listOf(
        HotelModel(
            name = "Ressort Hotel",
            rating = 4.5,
            distance = 500,
            price = 15.0,
            image = hotelImages[0],
            location = "Johannesburg"
        ),
        HotelModel(
            name = "Windsor Hotel",
            rating = 4.3,
            distance = 500,
            price = 80.0,
            image = hotelImages[1],
            location = "Johannesburg"
        ),
        HotelModel(
            name = "Hilton Hotel",
            rating = 4.0,
            distance = 600,
            price = 120.0,
            image = hotelImages[2],
            location = "Johannesburg"
        ),
        HotelModel(
            name = "Marriot Hotel",
            rating = 4.8,
            distance = 700,
            price = 15.0,
            image = hotelImages[3],
            location = "Johannesburg"
        ),
    )

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
                Box(

                ) {
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
                            .align(Alignment.BottomCenter)
                            .padding(15.dp)
                            .background(
                                Color.White.copy(alpha = 0.9f),
                                shape = RoundedCornerShape(8.dp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        DateRoomsPicker(
                            checkInDate = checkInDate.value,
                            checkOutDate = checkOutDate.value,
                            rooms = rooms.value,
                            onShowDatePickerChange = { showDatePicker = it },
                            onShowRoomPickerChange = { showRoomDialog = it },
                        )
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
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

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    hotelList.forEach { hotel ->
                        SearchCard(hotel = hotel)
                    }
                }

            }
        }

        var dateRangePickerState = rememberDateRangePickerState()

        Spacer(modifier = Modifier.padding(innerPa))
        // Date Picker Dialog
        if (showDatePicker) {
            HotelDatePicker(
                dateRangePickerState = dateRangePickerState,
                onDismiss = { showDatePicker = false },
                onConfirm = {
                    checkInDate.value = it.selectedStartDateMillis?.let { it1 ->
                        convertMillisToLocalDate(
                            it1
                        )
                    }
                    checkOutDate.value = it.selectedEndDateMillis?.let { it1 ->
                        convertMillisToLocalDate(
                            it1
                        )
                    }
                    showDatePicker = false
                }
            )
        }

        // Room and Adult Picker Dialog
        if (showRoomDialog) {
            ModalBottomSheet(
                modifier = Modifier.fillMaxWidth(),
                onDismissRequest = { showRoomDialog = false },
                sheetState = sheetState,
            ) {
                RoomPickerDialog(
                    rooms = rooms,
                    adults = adults,
                    kids = kids,
                    onClose = { showRoomDialog = false },
                    onDismiss = { showRoomDialog = false },
                    onConfirm = { selectedRooms, selectedAdults, selectedKids ->
                        rooms.value = selectedRooms
                        adults.value = selectedAdults
                        kids.value = selectedKids
                        showRoomDialog = false
                    }
                )
            }
        }
    }
}

fun convertMillisToLocalDate(millis: Long): LocalDate {
    return Instant.ofEpochMilli(millis)
        .atZone(ZoneId.systemDefault()) // Convert to system's default timezone
        .toLocalDate() // Convert to LocalDate
}

