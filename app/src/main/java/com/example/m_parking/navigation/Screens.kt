package com.example.m_parking.navigation

sealed class Screens(val route: String) {
    object HomeScreen : Screens("Home_screen")
    object SearchScreen : Screens("Search_screen")
    object ProfileScreen : Screens("Profile_screen")
    object TicketScreen : Screens("Ticket_Screen")
    object SettingsScreen : Screens("Settings_Screen")
    object SplashScreen : Screens("Splash_Screen")
    object WelcomeScreen : Screens("Welcome_Screen")
    object SignUpScreen : Screens("SignUp_Screen")
    object LogInScreen : Screens("LogIn_Screen")
    object ProfileImageScreen : Screens("Profile_image_Screen")
}