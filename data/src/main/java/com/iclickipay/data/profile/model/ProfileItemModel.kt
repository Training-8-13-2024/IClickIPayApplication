package com.iclickipay.data.profile.model


import com.google.gson.annotations.SerializedName

data class ProfileItemModel(
    @SerializedName("info")
    val info: InfoModel? = InfoModel(),
    @SerializedName("results")
    val results: List<ResultModel?>? = listOf()
)