package com.iclickipayapplication.viewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iclickipay.data.model.learn.TeacherDataItemItemModel
import com.iclickipay.data.repository.learn.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeacherAdapter @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _upcomingData = mutableStateOf<List<TeacherDataItemItemModel>>(emptyList())
    val upcomingData: State<List<TeacherDataItemItemModel>> = _upcomingData

    init {
        fetchDetails()

    }

    fun fetchDetails() {
        viewModelScope.launch {
            try {
                val details = repository.getDetailsTeacher()
                _upcomingData.value = details as List<TeacherDataItemItemModel>
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching data: ${e.message}")
            }
        }
    }
}