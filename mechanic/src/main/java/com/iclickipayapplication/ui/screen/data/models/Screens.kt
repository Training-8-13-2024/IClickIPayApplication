package com.iclickipayapplication.ui.screen.data.models

import com.iclickipayapplication.ui.screen.data.interfaces.NavigationIntMechanic

sealed class Screens(override val route: String, override val title: String) : NavigationIntMechanic {
    object Home : Screens("Home","Home")
    object Info : Screens("Info","Info")
    object Login : Screens("Login","Login")
    object Main : Screens("Main","Main")
//    object Doctor : Screens("Doctor","Doctor")
//    object Doctor : Screens("Doctor","Doctor")
//    object Doctor : Screens("Doctor","Doctor")
//    object Doctor : Screens("Doctor","Doctor")
}