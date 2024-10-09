package com.iclickipay.data.doctor.models


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class PatientModel(
    @SerializedName("code")
    @Expose
    val code: Int?,
    @SerializedName("data")
    @Expose
    val `data`: Data?,
    @SerializedName("status")
    @Expose
    val status: String?
)