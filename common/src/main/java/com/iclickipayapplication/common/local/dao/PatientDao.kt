package com.iclickipayapplication.common.local.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iclickipayapplication.common.local.entities.PatientData
import com.iclickipayapplication.common.local.models.Patient


@Dao
interface PatientDao {

    @Insert
    suspend fun insertPatient(patient: PatientData)

    @Query("SELECT * FROM patient_data")
    suspend fun getAllPatients(): List<PatientData>

    @Query("SELECT * FROM patient_data WHERE id = :id")
    suspend fun getPatientById(id: Long): PatientData

    @Query("DELETE FROM patient_data WHERE id = :id")
    suspend fun deletePatient(id: Long)


    @Update
    suspend fun updatePatient(patient: PatientData)
}