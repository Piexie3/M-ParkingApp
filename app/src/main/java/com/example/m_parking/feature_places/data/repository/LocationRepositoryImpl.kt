package com.example.m_parking.feature_places.data.repository

import android.content.Context
import android.location.Location
import com.daematech.m_parking.core.utils.Resource
import com.example.m_parking.feature_places.domain.repository.LocationRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
): LocationRepository {
    override fun getUpdatedLocation(interval: Long): Flow<Location> {
        TODO("Not yet implemented")
    }

    override fun getCurrentLocation(): Resource<Location> {
        TODO("Not yet implemented")
    }
}