package com.example.m_parking.feature_onboading.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m_parking.feature_auth.domain.repository.AuthRepository
import com.example.m_parking.feature_auth.presentation.viewModel.AuthViewModel
import com.example.m_parking.feature_onboading.data.repository.DataStoreRepository
import com.example.m_parking.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository,
//    private val authViewModel: AuthViewModel
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Screens.WelcomeScreen.route)
    val startDestination: State<String> = _startDestination

//    val currentUser = authViewModel.currentUser
    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = Screens.HomeScreen.route
                }
//                else if (currentUser == null && completed){
//                    _startDestination.value = Screens.SignUpScreen.route
//                }
                else{
                    _startDestination.value = Screens.WelcomeScreen.route
                }
            }
            _isLoading.value = false
        }
    }

}