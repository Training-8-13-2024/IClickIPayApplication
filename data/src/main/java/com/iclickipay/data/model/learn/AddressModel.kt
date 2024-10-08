package com.iclickipay.data.model.learn


import com.google.gson.annotations.SerializedName

data class AddressModel(
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("street")
    val street: String? = "",
    @SerializedName("zip")
    val zip: String? = ""
)