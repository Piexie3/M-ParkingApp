package com.daematech.m_parking.feature_onboading.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daematech.m_parking.feature_auth.domain.repository.AuthRepository
import com.daematech.m_parking.feature_onboading.data.repository.DataStoreRepository
import com.daematech.m_parking.feature_onboading.domain.repository.OnBoardingRepository
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(completed = completed)
        }
    }

}