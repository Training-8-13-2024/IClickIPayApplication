package com.iclickipayapplication.common.local.models

import com.google.gson.annotations.SerializedName
import com.iclickipayapplication.common.local.entities.PatientData
import kotlin.reflect.KProperty

data class Patient(
    @SerializedName("id") val id: Long = 0,
    @SerializedName("gender") val gender: Int= 0,
    @SerializedName("option") var option: Int?= null,
    @SerializedName("age") val age: Int = 0,
    @SerializedName("item") val item: String? = null,
    @SerializedName("injury") val injury: String?= null,
    @SerializedName("severity") val severity: Int= 0,
    @SerializedName("symptoms") val symptoms: String?= null,

    ) {
    operator fun getValue(nothing: Nothing?, property: KProperty<*>): Any {
        return this
    }
}

fun Patient.toPatientData(): PatientData {
    return PatientData(
        gender = this.gender,
        age = this.age,
        option = this.option,
        item = this.item,
        injury = this.injury,
        severity = this.severity,
        symptoms = this.symptoms
    )
}