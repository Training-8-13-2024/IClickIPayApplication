package com.iclickipayapplication.ui.screen.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.iclickipayapplication.ui.screen.data.models.Mechanic
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MechanicViewModel: ViewModel() {
    private val _state = MutableStateFlow(Mechanic.listOfMechanics)
    fun getMechanics(): List<Mechanic>  = _state.value
}