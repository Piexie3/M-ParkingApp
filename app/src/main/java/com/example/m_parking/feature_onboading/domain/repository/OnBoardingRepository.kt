package com.daematech.m_parking.feature_onboading.domain.repository

import kotlinx.coroutines.flow.Flow

interface OnBoardingRepository {
    suspend fun setOnBoardingFinished(finished: Boolean)

    fun getOnBoardingFinished(): Flow<Boolean>
}