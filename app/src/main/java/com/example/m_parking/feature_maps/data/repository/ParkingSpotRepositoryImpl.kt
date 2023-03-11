package com.example.m_parking.feature_maps.data.repository

import com.example.m_parking.feature_maps.data.ParkingSpotDao
import com.example.m_parking.feature_maps.data.toParkingSpot
import com.example.m_parking.feature_maps.data.toParkingSpotEntity
import com.example.m_parking.feature_maps.domain.model.ParkingSpot
import com.example.m_parking.feature_maps.domain.repository.ParkingSpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ParkingSpotRepositoryImpl(
    private val dao: ParkingSpotDao
) : ParkingSpotRepository {
    override suspend fun insertParkingSpot(spot: ParkingSpot) {
        dao.insertParkingSpot(spot.toParkingSpotEntity())
    }

    override suspend fun deleteParkingSpot(spot: ParkingSpot) {
        dao.deleteParkingSpot(spot.toParkingSpotEntity())
    }

    override fun getParkingSpots(): Flow<List<ParkingSpot>> {
        return dao.getParkingSports().map { spots->
            spots.map { it.toParkingSpot() }
        }
    }
}