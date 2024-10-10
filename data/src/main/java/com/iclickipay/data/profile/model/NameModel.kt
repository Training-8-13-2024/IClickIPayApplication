package com.iclickipay.data.profile.model


import com.google.gson.annotations.SerializedName

data class NameModel(
    @SerializedName("first")
    val first: String? = "",
    @SerializedName("last")
    val last: String? = "",
    @SerializedName("title")
    val title: String? = ""
)