package com.iclickipayapplication.ui.screen.data.constants

import androidx.compose.ui.unit.dp
import com.iclickipay.bank.R


val HORIZONAL_PADDING = 17.dp
val VERTICAL_PADDING = 40.dp
val GREY = 0xFFA6AAB4
private val BALANCE = "100500.21"
private val CVV = "523"
private val ACCOUNT_NUMBER = "423475677906"
private val CARD_NUMBER = "689322204445"

data class User(
    val userImage: Int,
    val userName: String,
    val userBalance: String = BALANCE,
    val cvv: String = CVV,
    val accountNumber: String = ACCOUNT_NUMBER,
    val cardNumber: String = CARD_NUMBER
){
    companion object{
        val DEFAULT_User = User(
            userImage = R.drawable.photo01,
            userName = "Bruce Wayne",
            userBalance = BALANCE,
            cvv = CVV,
            accountNumber = ACCOUNT_NUMBER,
            cardNumber = CARD_NUMBER
        )
    }

}