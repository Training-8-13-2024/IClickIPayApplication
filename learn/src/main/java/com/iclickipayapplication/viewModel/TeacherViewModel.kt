package com.iclickipayapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iclickipay.data.learn.local.dao.TeacherBookingDao
import com.iclickipay.data.learn.local.entity.TeacherBookingEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LearnTeacherViewModel @Inject constructor(
    private val teacherBookingDao: TeacherBookingDao
) : ViewModel() {

    private val _upcomingData = MutableLiveData<List<TeacherBookingEntity>>()
    val upcomingData: LiveData<List<TeacherBookingEntity>> = _upcomingData





    fun insertBooking(booking: TeacherBookingEntity) {
        viewModelScope.launch {
            teacherBookingDao.insertBooking(booking)
        }
    }

    fun updateBooking(booking: TeacherBookingEntity) {
        viewModelScope.launch {
            teacherBookingDao.updateBooking(booking)
        }
    }

    fun loadBookings() {
        viewModelScope.launch {
            val bookings = teacherBookingDao.getAllBookings()
            _upcomingData.value = bookings
        }
    }

    fun deleteBooking(booking: TeacherBookingEntity) {
        viewModelScope.launch {
            teacherBookingDao.deleteBooking(booking)
        }
    }

//    suspend fun getBookingById(id: Int): LiveData<TeacherBookingEntity?> {
//        return teacherBookingDao.getBookingById(id).asLiveData()
//    }
//
//    // Function to get all bookings
//    suspend fun getAllBookings(): LiveData<List<TeacherBookingEntity>> {
//        return teacherBookingDao.getAllBookings().asLiveData()
//    }
}
