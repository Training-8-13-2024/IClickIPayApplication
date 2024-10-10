package com.iclickipayapplication.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SharedViewModel : ViewModel() {
    private val _imageUri = MutableLiveData<String?>()
    val imageUri: LiveData<String?> = _imageUri

    fun setImageUri(uri: String?) {
        _imageUri.value = uri
    }
}