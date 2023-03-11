package com.example.m_parking.feature_maps.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m_parking.feature_maps.domain.model.ParkingSpot
import com.example.m_parking.feature_maps.domain.repository.ParkingSpotRepository
import com.google.android.gms.maps.model.MapStyleOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val repository: ParkingSpotRepository
) : ViewModel() {
    var state by mutableStateOf(MapState())

    init {
        viewModelScope.launch {
            repository.getParkingSpots().collectLatest {spots->
                state = state.copy(
                    parkingSpots = spots
                )
            }
        }
    }

    fun onEvent(event: MapEvents) {
        when (event) {
            is MapEvents.ToggleFalloutMap -> {
                state = state.copy(
                    properties = state.properties.copy(
                        mapStyleOptions = if (state.isFalloutMap) {
                            null
                        } else MapStyleOptions(MapStyle.json),
                       isTrafficEnabled = !state.isFalloutMap

                    ),
                    isFalloutMap = !state.isFalloutMap
                )
            }
            is MapEvents.OnMapLongClick -> {
                viewModelScope.launch {
                    repository.insertParkingSpot(
                        ParkingSpot(
                            event.latLng.latitude,
                            event.latLng.longitude
                        )
                    )
                }
            }
            is MapEvents.OnInfoWindowLongClick ->{
                viewModelScope.launch {
                    repository.deleteParkingSpot(event.spot)
                }
            }
        }
    }
}