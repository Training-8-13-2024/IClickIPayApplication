package com.iclickipayapplication.ui.domain

import android.content.Context
import android.location.LocationManager
import androidx.core.content.ContextCompat

fun isLocationEnabled(context: Context): Boolean {
    val locationManager = ContextCompat.getSystemService(context, LocationManager::class.java)
    return locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER) == true ||
            locationManager?.isProviderEnabled(LocationManager.NETWORK_PROVIDER) == true
}