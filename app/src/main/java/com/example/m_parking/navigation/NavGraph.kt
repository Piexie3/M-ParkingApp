package com.example.m_parking.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.m_parking.feature_account.presentation.profile.ProfileImageScreen
import com.example.m_parking.feature_account.presentation.profile.ProfileScreen
import com.example.m_parking.feature_account.presentation.search.SearchScreen
import com.example.m_parking.feature_account.presentation.settings.SettingsScreen
import com.example.m_parking.feature_auth.presentation.login.LoginScreen
import com.example.m_parking.feature_auth.presentation.viewModel.AuthViewModel
import com.example.m_parking.feature_onboading.presentation.SplashViewModel
import com.example.m_parking.feature_onboading.presentation.WelcomeScreen
import com.example.m_parking.feature_parking.presentation.home.HomeScreen
import com.example.m_parking.feature_parking.presentation.ticket.TicketScreen
import com.manubett.auth.presentation.signup.SignUpScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
    viewModel: AuthViewModel = viewModel()
    ) {
   NavHost(
       navController = navController,
       startDestination = startDestination
   ) {
       composable(Screens.HomeScreen.route){
           HomeScreen(navController)
       }

       composable(Screens.SearchScreen.route){
           SearchScreen(navController)
       }
       composable(Screens.TicketScreen.route){
           TicketScreen(navController)
       }
       composable(Screens.ProfileScreen.route){
           ProfileScreen(navController)
       }
       composable(Screens.SettingsScreen.route){
           SettingsScreen(navController)
       }
       composable(Screens.WelcomeScreen.route){
           WelcomeScreen(navController)
       }
       composable(Screens.LogInScreen.route){
           LoginScreen(viewModel,navController)
       }
       composable(Screens.SignUpScreen.route){
           SignUpScreen(viewModel,navController)
       }
       composable(Screens.ProfileImageScreen.route){
           ProfileImageScreen(navController)
       }
   }
}
