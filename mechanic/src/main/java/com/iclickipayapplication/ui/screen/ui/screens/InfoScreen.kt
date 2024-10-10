package com.iclickipayapplication.ui.screen.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.mechanic.R
import com.iclickipayapplication.common.constants.HORIZONAL_PADDING
import com.iclickipayapplication.common.ui.components.ButtonComponent
import com.iclickipayapplication.common.ui.components.HeaderComponent
import com.iclickipayapplication.ui.screen.data.constants.vehicleData
import com.iclickipayapplication.ui.screen.ui.components.DropDownMenu


@Composable
fun InfoScreen(
    navController: NavHostController
){

    val vehicleType = remember { vehicleData }

    val selectedVehicleType = remember { mutableStateOf("Car") }

    val selectedModel = remember { mutableStateOf(vehicleType["Car"]?.keys?.firstOrNull()) }
    val selectedYear = remember { mutableStateOf(vehicleType["Car"]?.get(selectedModel.value!!)?.keys?.firstOrNull()) }
    val selectedFuelType = remember { mutableStateOf(vehicleType["Car"]?.get(selectedModel.value!!)?.get(selectedYear.value!!)?.firstOrNull()) }

    fun updateSelections(vehicle: String, model: String?, year: String?, fuel: String?) {
        selectedVehicleType.value = vehicle
        selectedModel.value = model ?: vehicleType[vehicle]?.keys?.firstOrNull()
        selectedYear.value = year ?: vehicleType[vehicle]?.get(selectedModel.value!!)?.keys?.firstOrNull()
        selectedFuelType.value = fuel ?: vehicleType[vehicle]?.get(selectedModel.value!!)?.get(selectedYear.value!!)?.firstOrNull()
    }

    val data = mapOf(
        "vehicleType" to selectedVehicleType.value,
        "selectedModel" to selectedModel.value,
        "selectedYear" to selectedYear.value,
        "selectedFuelType" to selectedFuelType.value
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp, horizontal = HORIZONAL_PADDING),
            ) {
            HeaderComponent(
                onClick = {
                    navController.navigate("home")
                },
                headerText = "Your Mechanic",
                iconSource = R.drawable.baseline_home_24,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Column(
            modifier = Modifier
                .padding(horizontal = HORIZONAL_PADDING)
                .weight(.7f)
                .fillMaxWidth()
        ) {
            Text(
                text = "Car Information",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(10.dp))
            DropDownMenu(
                items = vehicleType.keys.toList(),
                selectedItem = selectedVehicleType.value,
                onItemSelected = {
                    updateSelections(it, null, null, null)
                },
                label = "Vehicle Type"
            )
            DropDownMenu(
                items = vehicleType[selectedVehicleType.value]?.keys?.toList() ?: emptyList(),
                selectedItem = selectedModel.value ?: "",
                onItemSelected = { model ->
                    updateSelections(selectedVehicleType.value, model, null, null)
                },
                label = "Vehicle Model"
            )
            DropDownMenu(
                items =  vehicleType[selectedVehicleType.value]?.get(selectedModel.value!!)?.keys?.toList() ?: emptyList(),
                selectedItem = selectedYear.value ?: "",
                onItemSelected = { year ->
                    updateSelections(selectedVehicleType.value, selectedModel.value, year, null)
                },
                label = "Year"
            )
            DropDownMenu(
                items = vehicleType[selectedVehicleType.value]?.get(selectedModel.value!!)?.get(selectedYear.value!!)?.toList() ?: emptyList(),
                selectedItem = selectedFuelType.value ?: "",
                onItemSelected = { fuel ->
                    updateSelections(selectedVehicleType.value, selectedModel.value, selectedYear.value, fuel)
                },
                label = "Motor"
            )

        }
        Row(
            modifier = Modifier
                .weight(.2f)
                .fillMaxWidth()
                .padding(horizontal = HORIZONAL_PADDING),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ButtonComponent(
                onclick = {
                   navController.navigate("mechanic_home")
                },
                text = "Next",
                fillwidth = true,
            )
        }
    }

}