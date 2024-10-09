package com.iclickipayapplication.ui.screen.data.models

import android.os.Parcelable
import com.iclickipay.mechanic.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mechanic(
    val id: Int,
    val name: String,
    val mechanicPic: Int,
    val location: String,
    val rating: String,
    val rate: String,
    val distance: String,
    val specialization: List<String>,
    val about: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
) : Parcelable {

    companion object{
        val listOfMechanics = listOf(
            Mechanic(
                id = 1,
                name = "Jessy Jones",
                mechanicPic = R.drawable.mechanic00,
                location = "28 Broad Street,Johannesburg",
                rating = "4.8",
                rate = "$20/h",
                distance = "500",
                specialization = listOf("Car", "Bike", "Truck")
            ),
            Mechanic(
                id = 2,
                name = "Jean Down",
                mechanicPic = R.drawable.mechanic01,
                location = "45 Broad Street,Johannesburg",
                rating = "4.5",
                rate = "$15/h",
                distance = "1000",
                specialization = listOf("Car", "Bike", "Truck")
            )
        )
    }
}