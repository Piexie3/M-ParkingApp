package com.daematech.m_parking.feature_maps.presentation

import com.daematech.m_parking.feature_maps.domain.model.ParkingSpot
import com.google.android.gms.maps.model.LatLng

sealed class MapEvents{
    object ToggleFalloutMap : MapEvents()
    data class OnMapLongClick(val latLng: LatLng): MapEvents()
    data class OnInfoWindowLongClick(val spot: ParkingSpot): MapEvents()
}
