package com.example.m_parking.feature_onboading.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m_parking.feature_auth.domain.repository.AuthRepository
import com.example.m_parking.feature_onboading.domain.repository.OnBoardingRepository
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val repository: OnBoardingRepository
) : ViewModel() {

    fun getCurrentUser(): FirebaseUser? {
        return authRepository.currentUser
    }

    fun setOnBoardingFinished(finished: Boolean) {
        viewModelScope.launch {
            repository.setOnBoardingFinished(finished)
        }
    }

    fun getOnBoardingFinished(): Flow<Boolean> = repository.getOnBoardingFinished()
}
