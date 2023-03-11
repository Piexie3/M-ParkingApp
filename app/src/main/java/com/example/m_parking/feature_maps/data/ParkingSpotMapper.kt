package com.example.m_parking.feature_maps.data

import com.example.m_parking.feature_maps.domain.model.ParkingSpot

fun ParkingSpotEntity.toParkingSpot(): ParkingSpot {
    return ParkingSpot(
        lat, lng, id
    )
}

fun ParkingSpot.toParkingSpotEntity(): ParkingSpotEntity {
    return ParkingSpotEntity(
        lat, lng, id
    )
}