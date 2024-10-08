package com.iclickipayapplication.ui.screen.data.models

import com.iclickipay.bank.R
import com.iclickipayapplication.ui.screen.data.interfaces.Navigation

sealed class HomeTabsItems(override val routes: String,override val icon: Int,override val label: String) : Navigation {
    object Send : HomeTabsItems("Send", label = "Send", icon = R.drawable.wallet)
    object Request : HomeTabsItems("Request", label = "Request", icon = R.drawable.wallet)
    object TopUp : HomeTabsItems("TopUp", label = "TopUp", icon = R.drawable.wallet)
}