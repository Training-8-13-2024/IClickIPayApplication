package com.iclickipayapplication.ui.screen.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.iclickipayapplication.ui.screen.data.models.Dummy
import kotlinx.coroutines.flow.MutableStateFlow

class TransactionViewModel: ViewModel() {
    private val _transactionstate = MutableStateFlow(Dummy.dummyList)
    val transactionstate = _transactionstate

    fun addTransaction(transaction: Dummy) {
        _transactionstate.value += transaction
    }
    fun getTransactions(): Map<String, List<Dummy>> = _transactionstate.value.groupBy { it.Date }.toMutableMap()
    fun getTransaction(
        transactionType: String
    ): Map<String, List<Dummy>> = _transactionstate.value.filter {
        it.TransactioType == transactionType
    }.groupBy { it.Date }.toMutableMap()
}