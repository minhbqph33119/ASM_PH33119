package com.example.asm_ph33119.ui.theme

sealed class  Screens(val screen: String){
    data object Home : Screens("home")
    data object BookMark : Screens("bookmark")
    data object Notification : Screens("notification")
    data object Profile : Screens("profile")
    data object ProductInformation : Screens("productinformation")
    data object Cart : Screens("cart")
    data object Signin : Screens("signin")
    data object Login : Screens("Login")
}