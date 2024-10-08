package iclickipay.doctor.data.repository

import android.util.Log
import com.iclickipay.data.doctor.local.dao.PatientDao
import com.iclickipay.data.doctor.local.entities.PatientData
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepoImpl @Inject constructor(
    private val patientDao: PatientDao
) : Repository {
    override suspend fun insertPatient(patient: PatientData) {
        Log.i("RepoImpl", "insertPatient: $patient")
        patientDao.insertPatient(patient)
    }

    override suspend fun getAllPatients(): List<PatientData> {
        return patientDao.getAllPatients()
    }

    override suspend fun getPatientById(id: Long): PatientData {
        return patientDao.getPatientById(id)
    }

    override suspend fun deletePatient(patient: PatientData) {
        patientDao.deletePatient(patient.id)
    }

    override suspend fun updatePatient(patient: PatientData) {
        patientDao.updatePatient(patient)
    }

    override suspend fun PatientDao(): PatientDao {
        return patientDao
    }

}