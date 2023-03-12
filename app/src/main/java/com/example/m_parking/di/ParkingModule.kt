package com.example.m_parking.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.m_parking.feature_maps.data.ParkingSportDatabase
import com.example.m_parking.feature_maps.data.repository.ParkingSpotRepositoryImpl
import com.example.m_parking.feature_maps.domain.repository.ParkingSpotRepository
import com.example.m_parking.feature_onboading.data.repository.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ParkingModule {
    @Singleton
    @Provides
    fun providesParkingSportDatabase(app: Application): ParkingSportDatabase {
        return Room.databaseBuilder(
            app,
            ParkingSportDatabase::class.java,
            "parking_spots_db"
        ).build()
    }


    @Provides
    @Singleton
    fun provideDataStoreRepository(@ApplicationContext context: Context) = DataStoreRepository(context = context)

    @Singleton
    @Provides
    fun provideParkingSpotRepository(db: ParkingSportDatabase): ParkingSpotRepository {
        return ParkingSpotRepositoryImpl(db.dao)
    }

}