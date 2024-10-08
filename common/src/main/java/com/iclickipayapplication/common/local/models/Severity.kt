package com.iclickipayapplication.common.local.models


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Severity(
    @SerializedName("level")
    @Expose
    val level: String?,
    @SerializedName("score")
    @Expose
    val score: Int?
)