package com.daematech.m_parking.feature_maps.data.remote

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ParkingSpotEntity::class],
    version = 1
)
abstract class ParkingSportDatabase : RoomDatabase(){
    abstract val dao: ParkingSpotDao
}