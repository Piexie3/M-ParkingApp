package com.example.m_parking.di

import android.app.Application
import androidx.room.Room
import com.example.m_parking.feature_maps.data.ParkingSportDatabase
import com.example.m_parking.feature_maps.data.repository.ParkingSpotRepositoryImpl
import com.example.m_parking.feature_maps.domain.repository.ParkingSpotRepository
import com.example.m_parking.feature_onboading.data.repository.OnBoardingDataRepository
import com.example.m_parking.feature_onboading.domain.repository.OnBoardingRepository
import com.google.firebase.auth.FirebaseAuth
import com.example.m_parking.feature_auth.data.repository.AuthRepositoryImpl
import com.example.m_parking.feature_auth.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesParkingSportDataabase(app: Application): ParkingSportDatabase {
        return Room.databaseBuilder(
            app,
            ParkingSportDatabase::class.java,
            "parking_spots_db"
        ).build()
    }


    @Singleton
    @Provides
    fun providesOnBoardingDataRepository(context: Application): OnBoardingRepository {
        return OnBoardingDataRepository(context)
    }

    @Singleton
    @Provides
    fun provideParkingSpotRepository(db: ParkingSportDatabase): ParkingSpotRepository {
        return ParkingSpotRepositoryImpl(db.dao)
    }


    @Provides
    @Singleton
    fun providesFirebaseAuth(): FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun providesRepository(impl : AuthRepositoryImpl): AuthRepository =impl

}