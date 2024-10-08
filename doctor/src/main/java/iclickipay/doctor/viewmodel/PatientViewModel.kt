package iclickipay.doctor.viewmodel

import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iclickipayapplication.common.local.dao.PatientDao
import com.iclickipayapplication.common.local.entities.PatientData
import com.iclickipayapplication.common.local.models.Patient
import com.iclickipayapplication.common.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PatientViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

//    holder for patient details temporarily
    public var _patientTemp = mutableStateOf(Patient())
    val patientTemp : State<Patient> = _patientTemp

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
        viewModelScope.launch {repository.insertPatient(patient)}
    }

    suspend fun getAllPatients() {
        viewModelScope.launch {repository.getAllPatients()}
    }

    suspend fun getPatientById(id: Long){
        viewModelScope.launch {repository.getPatientById(id)}
    }

    suspend fun deletePatient(patient: PatientData) {
        viewModelScope.launch {repository.deletePatient(patient)}
    }

    suspend fun PatientDao() {
        viewModelScope.launch {repository.PatientDao()}
    }

    suspend fun updatePatient(patient: PatientData) {
        viewModelScope.launch {repository.updatePatient(patient)}
    }

}