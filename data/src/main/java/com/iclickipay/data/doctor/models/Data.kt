package com.iclickipay.data.doctor.models


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Data(
    @SerializedName("age")
    @Expose
    val age: Int?,
    @SerializedName("gender")
    @Expose
    val gender: Int?,
    @SerializedName("injuries")
    @Expose
    val injuries: List<Injury?>?,
    @SerializedName("items")
    @Expose
    val items: List<String?>?
)