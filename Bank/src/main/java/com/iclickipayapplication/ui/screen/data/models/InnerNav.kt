package com.iclickipayapplication.ui.screen.data.models

import com.iclickipayapplication.ui.screen.data.interfaces.NavigationIntBank

sealed class InnerNav(override val routes: String): NavigationIntBank {
    object All : InnerNav("All")
    object Received : InnerNav("Received")
    object Sent : InnerNav("Sent")

}