package com.example.m_parking.feature_maps.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ParkingSpotEntity::class],
    version = 1
)
abstract class ParkingSportDatabase : RoomDatabase(){
    abstract val dao: ParkingSpotDao
}