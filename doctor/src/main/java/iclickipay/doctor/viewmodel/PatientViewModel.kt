package iclickipay.doctor.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iclickipay.data.doctor.local.dao.PatientDao
import com.iclickipay.data.doctor.local.entities.PatientData
import com.iclickipay.data.doctor.local.entities.toPatient
import com.iclickipay.data.doctor.models.Patient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PatientViewModel @Inject constructor(
    private val patientDao: PatientDao,
) : ViewModel() {

    init {
        viewModelScope.launch {
            try {
                var patients = patientDao.getAllPatients()
                _patient.value = patients[0].toPatient()
            } catch (e: Exception) {
            }
        }
    }

    //    holder for patient details temporarily
    public var _patientTemp = mutableStateOf(Patient())
    val patientTemp: State<Patient> = _patientTemp

    //    fun to set patient details property by property temporarily using on one object
    fun setPatientTemp(pat: Patient) {
        _patientTemp = mutableStateOf(pat)
        _patient.value = pat
    }


    // To hold patient details, originally LiveData, now StateFlow
    private val _patient = MutableStateFlow(Patient())
    val patient: StateFlow<Patient> = _patient


    // Add the required functions here
    fun insertPatient(patient: PatientData) {
        viewModelScope.launch { patientDao.insertPatient(patient) }
    }

    fun getAllPatients() {
        viewModelScope.launch { patientDao.getAllPatients() }
    }

    fun getPatientById(id: Long) {
        viewModelScope.launch { patientDao.getPatientById(id) }
    }

    fun deletePatient(patient: PatientData) {
        viewModelScope.launch { patientDao.deletePatient(patient.id) }
    }

//    suspend fun PatientDao() {
//        viewModelScope.launch {patientDao.PatientDao()}
//    }

    fun updatePatient(patient: PatientData) {
        viewModelScope.launch { patientDao.updatePatient(patient) }
    }

}