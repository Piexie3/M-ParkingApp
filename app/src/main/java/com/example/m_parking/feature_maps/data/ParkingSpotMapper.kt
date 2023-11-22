package com.daematech.m_parking.feature_maps.data

import com.daematech.m_parking.feature_maps.data.remote.ParkingSpotEntity
import com.daematech.m_parking.feature_maps.domain.model.ParkingSpot

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