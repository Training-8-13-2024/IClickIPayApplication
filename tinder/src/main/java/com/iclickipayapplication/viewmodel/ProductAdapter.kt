package com.iclickipayapplication.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iclickipay.data.model.tinder.ProductsModelItemModel
import com.iclickipay.data.repository.learn.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ProductAdapter @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _upcomingData = mutableStateOf<List<ProductsModelItemModel>>(emptyList())
    val upcomingData: State<List<ProductsModelItemModel>> = _upcomingData

    init {
        fetchDetails()

    }

    fun fetchDetails() {
        viewModelScope.launch {
            try {
                val details = repository.getDetails()
                _upcomingData.value = details as List<ProductsModelItemModel>
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching data: ${e.message}")
            }
        }
    }
}