package com.iclickipay.data.profile.model


import com.google.gson.annotations.SerializedName

data class CoordinatesModel(
    @SerializedName("latitude")
    val latitude: String? = "",
    @SerializedName("longitude")
    val longitude: String? = ""
)