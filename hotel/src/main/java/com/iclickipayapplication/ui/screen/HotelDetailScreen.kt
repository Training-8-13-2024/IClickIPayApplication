package com.iclickipayapplication.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.hotel.R
import com.iclickipayapplication.common.ui.components.CustomButton
import com.iclickipayapplication.data.HotelModel
import com.iclickipayapplication.ui.HotelNavigation
import com.iclickipayapplication.ui.components.CardFooter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HotelDetailScreen(hotel: String, navController: NavHostController) {
    val hotelData = hotel.toHotelModel()
    var selectedImage by remember { mutableStateOf(0) }
    val hotelImages = listOf(
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
    )
    var showRoomDialog by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val bgcolor = remember {
        mutableStateOf(Color.Black)
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Image Carousel with LazyRow
        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(3) { index ->


                    Image(
                        painter = painterResource(id = hotelImages[index]),
                        contentDescription = null,
                        modifier = Modifier
                            .height(200.dp)
                            .width(300.dp)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                // Indicator for carousel
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    repeat(3) { index ->

                        if(index == selectedImage){
                            bgcolor.value = Color.Black
                        }else{
                            bgcolor.value = Color.Gray
                        }

                        Box(
                            modifier = Modifier
                                .size(if (index == selectedImage) 10.dp else 8.dp)
                                .clip(CircleShape)
                                .background(bgcolor.value)
                                .padding(8.dp)
                        )
                    }
                }
            }

        }

        item {
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(6.dp))
            )
            {
                CardFooter(hotel = hotelData)
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Call and Message Buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(modifier = Modifier.weight(0.5f))
                {
                    CustomButton(
                        text = "Call",
                        onClick = { /*TODO*/ },
                        bgcolor = Color(0xFFC4C4C4)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))

                Box(modifier = Modifier.weight(0.5f))
                {
                    CustomButton(
                        text = "Message",
                        onClick = { /*TODO*/ },
                        bgcolor = Color(0xFF10C971)
                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))

            // Rooms List
            Text("Rooms 2", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            // Room Items
        }

        item{
            HorizontalMultiBrowseCarousel(
                state = rememberCarouselState { hotelImages.count() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(221.dp),
                preferredItemWidth = 186.dp,
                itemSpacing = 8.dp,
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) { i ->
                val item = hotelImages[i]
                Image(
                    modifier = Modifier
                        .height(205.dp)
                        .maskClip(MaterialTheme.shapes.extraLarge),
                    painter = painterResource(id = item),
                    contentDescription = stringResource(item),
                    contentScale = ContentScale.Crop
                )
            }
        }

        items(2) { index ->
            when (index) {
                0 -> RoomItem(
                    roomType = "Junior Suite",
                    price = 150,
                    roomDetails = "2 Adults, 1 Kid, Wifi, Kingsize bed",
                    roomSizes = "12m²",
                    freeCancellation = true,
                    breakfast = true,
                    onClick = { showRoomDialog = true }
                )

                1 -> RoomItem(
                    roomType = "Executive Suite",
                    price = 190,
                    roomDetails = "2 Adults, 1 Kid, Wifi, Kingsize bed",
                    roomSizes = "12m²",
                    freeCancellation = true,
                    breakfast = false,
                    onClick = { showRoomDialog = true }
                )
            }
        }
        item {
            // Room and Adult Picker Dialog
            if (showRoomDialog) {
                ModalBottomSheet(
                    modifier = Modifier.fillMaxWidth(),
                    onDismissRequest = { showRoomDialog = false },
                    sheetState = sheetState,
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Standard",
                            )
                            Row(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_moon),
                                    contentDescription = "Moon"
                                )
                                Text(text = "$ 190", color = Color.Black)
                            }
                        }
                        Box(modifier = Modifier) {
                            Text(
                                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis sit amet odio in egestas. Pellen tesque ultricies justo.",
                                color = Color.Gray
                            )
                        }

                        Box(
//                            draw a border around the box
                            modifier = Modifier
                                .drawBehind {
                                    drawRect(Color.Gray, style = Stroke(width = 1.dp.toPx()))
                                }
                                .background(Color.Transparent, RoundedCornerShape(6.dp))
                                .size(80.dp)
                                .align(Alignment.CenterHorizontally),
                            contentAlignment = Alignment.Center
                        ) {


                            Text(
                                text = "2",
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                        }
                        Box(
                            modifier = Modifier
                        ) {
                            Text(
                                text = "Remove",
                                color = Color(0xFFFF6F00),
                            )
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            OutlinedButton(
                                border = null,
                                onClick = {
                                    navController.navigate(HotelNavigation.ORDER.name)
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp)
                                    .padding(vertical = 10.dp, horizontal = 20.dp),
                                shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFFF6F00),
                                    contentColor = Color.White
                                ),
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Box(modifier = Modifier.width(20.dp)){}
                                    Text(
                                        text = "Add to order",
                                        color = Color.White,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                    Text(text = "$ 190", color = Color.White)
                                }

                            }
                        }

                    }

                }
            }
        }
    }

    @Composable
    fun RoomItem(
        roomType: String,
        price: Int,
        roomDetails: String,
        roomSizes: String,
        freeCancellation: Boolean,
        breakfast: Boolean
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(roomType, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(roomDetails, fontSize = 14.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(4.dp))
                Text(roomSizes, fontSize = 14.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("\$$price", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    if (freeCancellation) {
                        Text("Free Cancellation", fontSize = 14.sp, color = Color.Green)
                    }
                    if (breakfast) {
                        Text("Breakfast Included", fontSize = 14.sp, color = Color.Green)
                    }
                }
            }
        }
    }
}


@Composable
fun RoomItem(
    roomType: String,
    price: Int,
    roomDetails: String,
    roomSizes: String,
    freeCancellation: Boolean,
    breakfast: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(roomType, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Room", color = Color(0xFFFF7A1A))
                    Text(text = "1", color = Color.DarkGray)
                }
                Column {
                    Text(text = "Adults", color = Color(0xFFFF7A1A))
                    Text(text = "1", color = Color.DarkGray)
                }
                Column {
                    Text(text = "Kids", color = Color(0xFFFF7A1A))
                    Text(text = "1", color = Color.DarkGray)
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 5.dp),
                color = Color.LightGray
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_wifi),
                        contentDescription = "wifi",
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Wifi", color = Color.Gray)
                }
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_beds),
                        contentDescription = "beds",
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Kingsize", color = Color.Gray)
                }
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_dimensions),
                        contentDescription = "Dimensions",
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("12 m", color = Color.Gray)
                }
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 5.dp),
                color = Color.LightGray
            )
//            main row
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
            )
            {
                PriceItem(price = 190, title = "Standard", onClick = onClick)
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 5.dp),
                    color = Color.LightGray
                )
                PriceItem(price = 210, title = "Free Cancellation", onClick = onClick)
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 5.dp),
                    color = Color.LightGray
                )
                PriceItem(
                    price = 230,
                    title = "Free Cancellation + Breakfast Included",
                    onClick = onClick
                )
            }
        }
    }
}


fun String.toHotelModel(): HotelModel {
    // Remove "HotelModel(" and the trailing ")"
    val cleanedString = this.removePrefix("HotelModel(").removeSuffix(")")

    // Split the key-value pairs
    val keyValuePairs = cleanedString.split(", ")

    // Create a map of the key-value pairs
    val map = keyValuePairs.associate {
        val (key, value) = it.split("=")
        key to value
    }

    // Extract values from the map and create a HotelModel object
    return HotelModel(
        name = map["name"] ?: "",
        rating = map["rating"]?.toDouble() ?: 0.0,
        distance = map["distance"]?.toInt() ?: 0,
        price = map["price"]?.toDouble() ?: 0.0,
        image = map["image"]?.toInt() ?: 0,
        location = map["location"] ?: ""
    )
}


@Composable
fun PriceItem(
    price: Int,
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = modifier
                .padding(16.dp)
                .weight(0.6f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
            )
        }
        Row(
            modifier = Modifier
                .weight(0.4f)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_moon),
                contentDescription = "Moon"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("$ $price", color = Color.Gray)
            Spacer(modifier = Modifier.width(18.dp))
            Box(
                modifier = Modifier
                    .clickable {
                        onClick()
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_add),
                    contentDescription = "Add",
                    tint = Color(0xFFFF7A1A)
                )
            }
        }
    }
}


@Composable
@Preview
fun HotelDetailScreenPreview() {
    HotelDetailScreen(
        hotel = HotelModel(
            name = "Resort Hotel",
            rating = 4.8,
            distance = 500,
            price = 150.0,
            image = R.drawable.image2,
            location = "Johannesburg"
        ).toString(),
        navController = NavHostController(LocalContext.current)
    )
}