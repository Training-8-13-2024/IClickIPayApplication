package com.iclickipayapplication.ui.screen.data.models

import com.iclickipay.bank.R

data class Dummy(
    val ReceipientName: String,
    val Amount: Float,
    val TransactioType: String,
    val Date: String,
    val userImage: Int
) {
    companion object {
        val dummyList = listOf(
            Dummy("Rebecca Moore", 972.00.toFloat(), "debit", "2023", R.drawable.profile00),
            Dummy("Rihanna Fenty", 125.00.toFloat(), "credit", "2019", R.drawable.profile01),
            Dummy("Franz Ferdinand", 125.00.toFloat(), "credit", "2019", R.drawable.profile01),
            Dummy("Franz Ferdinand", 125.00.toFloat(), "credit", "2019", R.drawable.profile01),
            Dummy("iclickigo", 9.50.toFloat(), "debit", "2019", R.drawable.profile002),
            Dummy("iclickigo", 9.50.toFloat(), "credit", "2014", R.drawable.profile002),
        )
    }
}