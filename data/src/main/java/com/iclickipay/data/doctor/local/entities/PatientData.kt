package com.iclickipay.data.doctor.local.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.iclickipay.data.doctor.models.Injury

// Main data entity
@Entity(tableName = "patient_data")
data class PatientData(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val gender: Int,
    val age: Int,
    val option: Int?,
    val item: String?,
    val injury: String?,
    val severity: Int,
    val symptoms: String?,
)

