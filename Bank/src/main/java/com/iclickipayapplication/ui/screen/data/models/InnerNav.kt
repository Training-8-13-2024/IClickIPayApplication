package com.iclickipayapplication.ui.screen.data.models

import com.iclickipayapplication.ui.screen.data.interfaces.Navigation

sealed class InnerNav(override val routes: String): Navigation {
    object All : InnerNav("All")
    object Sent : InnerNav("Sent")
    object Received : InnerNav("Received")
}