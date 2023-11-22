package com.daematech.m_parking.feature_maps.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MapScreen(
    viewModel: MapsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val uiSettings = remember {
        MapUiSettings(
            zoomControlsEnabled = false
        )
    }
    val nairobi = LatLng(-1.28333, 36.81667)
    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(nairobi, 11f)
    }
    Scaffold(
        modifier = Modifier.fillMaxHeight(),
        floatingActionButton = {
            Column {
                FloatingActionButton(
                    onClick = {
                        viewModel.onEvent(MapEvents.ToggleFalloutMap)
                    },
                    modifier = Modifier.clip(CircleShape),
                    contentColor = MaterialTheme.colorScheme.onBackground,
                    containerColor = MaterialTheme.colorScheme.background
                ) {
                    Icon(
                        imageVector = if (viewModel.state.isFalloutMap) {
                            Icons.Default.ToggleOn
                        } else Icons.Default.ToggleOff,
                        contentDescription = "Toggle followed map"
                    )

                }
                Spacer(modifier = Modifier.height(8.dp))
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.clip(CircleShape),
                    contentColor = MaterialTheme.colorScheme.onBackground,
                    containerColor = MaterialTheme.colorScheme.background
                ) {
                    Icon(
                        imageVector = Icons.Default.MyLocation,
                        contentDescription = "my location"
                    )
                }
            }

        }) {
        GoogleMap(
            modifier = Modifier,
            cameraPositionState=cameraPositionState,
            properties = viewModel.state.properties,
            uiSettings = uiSettings,
            onMapLongClick = {
                viewModel.onEvent(MapEvents.OnMapLongClick(it))
            },

        ) {
            viewModel.state.parkingSpots.forEach { spot ->
                Marker(
//                    position = LatLng(spot.lat, spot.lng),
                    title = "ParkingSpot(${spot.lat}, ${spot.lng})",
                    snippet = "long click to delete",
                    onInfoWindowLongClick = {
                        viewModel.onEvent(
                            MapEvents.OnInfoWindowLongClick(spot)
                        )
                    },
                    onClick = {
                        it.showInfoWindow()
                        true
                    },
                    icon = BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_GREEN
                    )
                )
            }
        }
    }
}