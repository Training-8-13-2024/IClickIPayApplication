package com.iclickipayapplication.common.repository

import com.iclickipayapplication.common.local.dao.PatientDao
import com.iclickipayapplication.common.local.entities.PatientData

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