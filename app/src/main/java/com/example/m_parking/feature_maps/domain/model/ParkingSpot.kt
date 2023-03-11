package com.example.m_parking.feature_maps.domain.model

import androidx.room.PrimaryKey

data class ParkingSpot(
    val  lat: Double,
    val  lng: Double,
    val id:Int? =null
)
