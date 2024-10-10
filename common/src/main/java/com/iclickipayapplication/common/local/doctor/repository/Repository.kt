package com.iclickipayapplication.common.local.doctor.repository

import com.iclickipay.data.doctor.local.dao.PatientDao
import com.iclickipay.data.doctor.local.entities.PatientData

interface Repository
{
    // Add the required functions here
    suspend fun insertPatient(patient: PatientData)
    suspend fun getAllPatients(): List<PatientData>
    suspend fun getPatientById(id: Long): PatientData
    suspend fun deletePatient(patient: PatientData)
    suspend fun updatePatient(patient: PatientData)


//    Add the required DAO
//    @Dao
    suspend fun PatientDao(): PatientDao
}