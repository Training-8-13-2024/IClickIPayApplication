package com.iclickipayapplication.ui.screen.data.models

import com.iclickipay.bank.R

sealed class Bankscreens(val icon: Int, val route: String){
    object Home: Bankscreens(R.drawable.home, "Home")
    object Wallet: Bankscreens(R.drawable.walletdefault, "Wallet")
    data class Send(val back: Bankscreens = Bankscreens.Wallet): Bankscreens(R.drawable.sendicon, "Send")
    object Message: Bankscreens(R.drawable.messagebottomnav, "Message")
    object Settings: Bankscreens(R.drawable.settings, "Settings")
}