package com.iclickipayapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iclickipay.data.tinder.local.dao.TinderBookingDao
import com.iclickipay.data.tinder.local.entity.TinderProfileEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TinderViewModel @Inject constructor(
    private val tinderBookingDao: TinderBookingDao
) : ViewModel()  {

    private val _upcomingData = MutableLiveData<List<TinderProfileEntity>>()
    val upcomingData: LiveData<List<TinderProfileEntity>> = _upcomingData

    init {
        loadProfiles()
    }

    fun insertBooking(booking: TinderProfileEntity) {
        viewModelScope.launch {
            tinderBookingDao.insertData(booking)
        }
    }

    fun updateBooking(booking: TinderProfileEntity) {
        viewModelScope.launch {
            tinderBookingDao.updateData(booking)
        }
    }

    fun loadProfiles() {
        viewModelScope.launch {
            val bookings = tinderBookingDao.getAllData()
            _upcomingData.value = bookings
        }
    }

    fun deleteBooking(booking: TinderProfileEntity) {
        viewModelScope.launch {
            tinderBookingDao.deleteData(booking)
        }
    }


}