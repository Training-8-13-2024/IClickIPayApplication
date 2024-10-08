package com.iclickipay.data.model.tinder


import com.google.gson.annotations.SerializedName

data class RatingModel(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("rate")
    val rate: Double? = 0.0
)