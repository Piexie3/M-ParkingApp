package com.example.m_parking.feature_maps.presentation

import com.example.m_parking.feature_maps.domain.model.ParkingSpot
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType

data class MapState(
    val properties: MapProperties = MapProperties(),
    val isFalloutMap: Boolean = false,
    val parkingSpots: List<ParkingSpot> = emptyList()
)
