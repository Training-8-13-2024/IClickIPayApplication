package com.iclickipayapplication.ui.screen.data.interfaces

interface Navigation {
    val routes: String
    val icon: Int?
        get() = null
    val label: String?
        get() = null
}