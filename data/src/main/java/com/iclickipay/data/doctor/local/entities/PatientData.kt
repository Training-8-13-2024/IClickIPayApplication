package com.iclickipay.data.doctor.local.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.iclickipay.data.doctor.models.Patient

// Main data entity
@Entity(tableName = "patient_data")
data class PatientData(
    @PrimaryKey(autoGenerate = true) val id: Long = 1,
    val gender: Int,
    val age: Int,
    val option: Int,
    val item: String,
    val injury: String,
    val severity: Int,
    val symptoms: String,
)

fun PatientData.toPatient(): Patient {
    return Patient(
        id = this.id,
        age = this.age,
        option = this.option,
        item = this.item,
        injury = this.injury,
        symptoms = this.symptoms,
        severity = this.severity,
    )
}
