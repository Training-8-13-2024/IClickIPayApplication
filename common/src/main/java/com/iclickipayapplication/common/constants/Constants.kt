package com.iclickipayapplication.common.constants

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.iclickipayapplication.common.R


val HORIZONTAL_PADDING = 17.dp
val VERTICAL_PADDING = 40.dp
const val GREY = 0xFFA6AAB4
val COLOR_GREY = R.color.grey
val BACKGROUND_COLOR = Color(247, 248, 249, 255)
val GO_BACK = R.drawable.backarrow
val ORANGE = R.color.orange

private const val BALANCE = "100500.21"
private const val CVV = "523"
private const val ACCOUNT_NUMBER = "423475677906"
private const val CARD_NUMBER = "689322204445"

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