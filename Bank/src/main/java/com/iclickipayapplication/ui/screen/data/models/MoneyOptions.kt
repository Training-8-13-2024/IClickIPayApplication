package com.iclickipayapplication.ui.screen.data.models

sealed class MoneyOptions() {
    object ASK_MONEY : MoneyOptions()
    object SEND_MONEY : MoneyOptions()
    object DEFAULT_SCREEN : MoneyOptions()
    data class SEND_MONEY_TO_RECIPIENT(val sender: Dummy, val amount: String) : MoneyOptions()
    data class SEND_MONEY_TO_SENDER(val sender: Dummy, val amount: String) : MoneyOptions()
    object END_SCREEN : MoneyOptions()
}
