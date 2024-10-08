package com.iclickipayapplication.common.local.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Embedded
import com.iclickipayapplication.common.local.models.Injury

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

