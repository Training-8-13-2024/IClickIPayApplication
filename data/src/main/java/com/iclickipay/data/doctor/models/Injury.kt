package com.iclickipay.data.doctor.models


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Injury(
    @SerializedName("cause")
    @Expose
    val cause: Boolean?,
    @SerializedName("description")
    @Expose
    val description: List<String?>?,
    @SerializedName("severity")
    @Expose
    val severity: Severity?,
    @SerializedName("type")
    @Expose
    val type: String?
)