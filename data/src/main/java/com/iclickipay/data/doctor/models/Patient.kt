package com.iclickipay.data.doctor.models

import com.google.gson.annotations.SerializedName
import com.iclickipay.data.doctor.local.entities.PatientData
import kotlin.reflect.KProperty

data class Patient(
    @SerializedName("id") var id: Long = 0,
    @SerializedName("gender") var gender: Int= 0,
    @SerializedName("option") var option: Int= 0,
    @SerializedName("age") var age: Int = 0,
    @SerializedName("item") val item: String = "",
    @SerializedName("injury") val injury: String= "",
    @SerializedName("severity") val severity: Int= 0,
    @SerializedName("symptoms") val symptoms: String= "",

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