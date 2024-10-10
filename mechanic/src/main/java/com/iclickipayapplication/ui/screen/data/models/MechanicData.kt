package com.iclickipayapplication.ui.screen.data.models

data class MechanicData(
    val vehicleType: String,
    val vehicleModel: String,
    val vehicleYear: String,
    val vehicleFuel: String,
    val vehicleHour: String,
    var date: String? = null
)

