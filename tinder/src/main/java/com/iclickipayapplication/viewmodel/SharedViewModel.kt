package com.iclickipayapplication.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SharedViewModel : ViewModel() {
    val capturedImage: MutableLiveData<Bitmap?> = MutableLiveData(null)

    fun setImage(bitmap: Bitmap?) {
        capturedImage.value = bitmap
    }
}