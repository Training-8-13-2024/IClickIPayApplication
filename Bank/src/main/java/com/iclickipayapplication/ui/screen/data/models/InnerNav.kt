package com.iclickipayapplication.ui.screen.data.models

sealed class InnerNav(val route: String) {
    object All : InnerNav("All")
    object Sent : InnerNav("Sent")
    object Received : InnerNav("Received")
}