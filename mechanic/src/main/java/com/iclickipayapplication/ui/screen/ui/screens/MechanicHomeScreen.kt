package com.iclickipayapplication.ui.screen.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.iclickipay.mechanic.R
import com.iclickipayapplication.common.constants.HORIZONTAL_PADDING
import com.iclickipayapplication.common.constants.ORANGE
import com.iclickipayapplication.ui.screen.data.models.MechanicData
import com.iclickipayapplication.ui.screen.ui.components.DatePickerModal
import com.iclickipayapplication.ui.screen.ui.components.MechanicListComponent
import com.iclickipayapplication.ui.screen.ui.components.SearchComponent
import com.iclickipayapplication.ui.screen.ui.viewmodel.MechanicViewModel
import java.text.SimpleDateFormat
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MechanicHomeScreen(
    navController: NavHostController,
    data: MechanicData
) {
    val orange = colorResource(ORANGE)
    val mechanicViewModel: MechanicViewModel = viewModel()
    val listOfMechanics = mechanicViewModel.getMechanics()
    val currentMechanic = remember {
        mutableStateOf(
            listOfMechanics[0]
        )
    }
    val showDatePicker = remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val formatter = SimpleDateFormat("MMMM-dd")
    val date = Date()
    val current = formatter.format(date)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        if (showDatePicker.value) {
            DatePickerModal(
                onDismiss = {
                    showDatePicker.value = false
                    data.date = datePickerState.selectedDateMillis?.let {
                        formatter.format(it)
                    }
                },
                state = datePickerState
            )
        }
        Box(
            modifier = Modifier
                .height(450.dp)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(R.drawable.mechanicbck),
                    contentDescription = "Mechanic Home",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .weight(.9f)
                        .fillMaxSize()
                )
                Row(
                    modifier = Modifier
                        .weight(.1f)
                        .fillMaxSize()
                        .background(color = colorResource(ORANGE))
                ) {

                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .weight(.4f)
                        .fillMaxSize()
                        .padding(horizontal = HORIZONTAL_PADDING),
                    verticalAlignment = Alignment.Top
                ) {
                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(color = Color.White),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_home_24),
                            contentDescription = "Home",
                            modifier = Modifier
                                .clickable {
                                    navController.navigate("home")
                                }
                                .size(30.dp),
                            tint = orange
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = HORIZONTAL_PADDING)
                        .weight(.6f),
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    SearchComponent(
                        location = "Johannesburg, 1 Road Ubuntu",
                        date = "${data.date?:current } - ${data.vehicleHour}h",
                        carType = data.vehicleType,
                        model = data.vehicleModel,
                        onDateClick = {
                            showDatePicker.value = true
                        }
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .height(intrinsicSize = IntrinsicSize.Min)
        ) {
            Row(
                modifier = Modifier
                    .background(color = colorResource(ORANGE))
                    .weight(.1f)
                    .fillMaxSize()
                    .padding(horizontal = HORIZONTAL_PADDING),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Icon(
                        painter = painterResource(R.drawable.heart),
                        contentDescription = "Favorites",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Text(
                        text = "Favorites",
                        color = Color.White
                    )
                }
                Row {
                    Icon(
                        painter = painterResource(R.drawable.icon),
                        contentDescription = "Favorites",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Text(
                        text = "Orders",
                        color = Color.White
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = HORIZONTAL_PADDING, vertical = 20.dp)
                    .weight(.9f)
                    .fillMaxSize()
            ) {
                MechanicListComponent(
                    listOfMechanics = listOfMechanics,
                    onMechanicClick = { mechanic ->
                        currentMechanic.value = mechanic
                        navController.navigate("mechanic_details/${mechanic.id}")
                    }
                )
            }
        }
    }
}