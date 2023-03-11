package com.example.m_parking.feature_onboading.data.repository

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.m_parking.feature_onboading.domain.repository.OnBoardingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class OnBoardingDataRepository @Inject constructor(val app: Application) : OnBoardingRepository {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "prefs")
        private val FINISHED_ON_BOARDING = booleanPreferencesKey("FINISHED_ON_BOARDING")
    }

    override suspend fun setOnBoardingFinished(finished: Boolean) {
        app.applicationContext.dataStore.edit { prefs ->
            prefs[FINISHED_ON_BOARDING] = finished
        }
    }

    override fun getOnBoardingFinished(): Flow<Boolean> {
        val finishedOnBoarding: Flow<Boolean> = app.applicationContext.dataStore.data
            .map { prefs ->
                prefs[FINISHED_ON_BOARDING] ?: false
            }
        return finishedOnBoarding
    }
}
