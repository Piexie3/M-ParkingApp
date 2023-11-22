package com.example.m_parking.feature_places.domain.repository

import android.location.Location
import com.daematech.m_parking.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getUpdatedLocation(interval: Long): Flow<Location>
    fun getCurrentLocation():Resource<Location>
}