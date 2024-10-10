package com.iclickipay.data.profile.model


import com.google.gson.annotations.SerializedName

data class LocationModel(
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("coordinates")
    val coordinates: CoordinatesModel? = CoordinatesModel(),
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("postcode")
    val postcode: Int? = 0,
    @SerializedName("state")
    val state: String? = "",
    @SerializedName("street")
    val street: StreetModel? = StreetModel(),
    @SerializedName("timezone")
    val timezone: TimezoneModel? = TimezoneModel()
)