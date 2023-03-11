package com.example.m_parking.feature_onboading.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m_parking.feature_auth.presentation.viewModel.AuthViewModel
import com.example.m_parking.feature_onboading.data.repository.OnBoardingDataRepository
import com.example.m_parking.navigation.Screens
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val repository: OnBoardingDataRepository,
    auth: AuthViewModel
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> =
        mutableStateOf(Screens.HomeScreen.route)
    val startDestination: State<String> = _startDestination

    private val currentUser = auth.currentUser

    init {
        viewModelScope.launch {
            repository.getOnBoardingFinished().collect { completed ->
                if (currentUser != null && completed) {
                    _startDestination.value = Screens.HomeScreen.route
                }
                else if (currentUser == null && completed){
                    _startDestination.value = Screens.SignUpScreen.route
                }
            }
            _isLoading.value = false
        }
    }

}