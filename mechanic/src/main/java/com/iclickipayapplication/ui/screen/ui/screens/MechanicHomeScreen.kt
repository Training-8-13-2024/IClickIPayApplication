package com.iclickipayapplication.ui.screen.ui.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.google.gson.Gson
import com.iclickipay.mechanic.R
import com.iclickipayapplication.common.constants.HORIZONAL_PADDING
import com.iclickipayapplication.common.constants.ORANGE
import com.iclickipayapplication.ui.screen.ui.components.MechanicListComponent
import com.iclickipayapplication.ui.screen.ui.components.SearchComponent
import com.iclickipayapplication.ui.screen.ui.viewmodel.MechanicViewModel

@Composable
fun MechanicHomeScreen(
    navController: NavHostController
) {
    val orange = colorResource(ORANGE)
    val mechanicViewModel: MechanicViewModel = viewModel()
    val listOfMechanics = mechanicViewModel.getMechanics()
    val currentMechanic = remember {
        mutableStateOf(
            listOfMechanics[0]
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .weight(.5f)
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
                        .padding(horizontal = HORIZONAL_PADDING),
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
                        .padding(horizontal = HORIZONAL_PADDING)
                        .weight(.6f),
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    SearchComponent(
                        location = "Johannesburg, 1 Road Ubuntu",
                        date = "20 Mar - 10h",
                        carType = "Car",
                        model = "Lexus"
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .weight(.5f)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .background(color = colorResource(ORANGE))
                    .weight(.1f)
                    .fillMaxSize()
                    .padding(horizontal = HORIZONAL_PADDING),
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
                    .padding(horizontal = HORIZONAL_PADDING, vertical = 20.dp)
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