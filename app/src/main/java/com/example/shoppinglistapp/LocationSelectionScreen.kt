package com.example.shoppinglistapp

import android.location.Location
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun LocationSelectionScreen(
    location: Location,
    onLocationSelected: (Location) -> Unit,
) {
    val userLocation = remember { mutableStateOf(LatLng(location.latitude, location.longitude)) }
    val cameraPosition = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(userLocation.value, 10f)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        GoogleMap(
            modifier = Modifier
                .weight(1f)
                .padding(top = 16.dp),
            cameraPositionState = cameraPosition,
            onMapClick = {
                userLocation.value = it
            }
        )
        {
            Marker(state = remember { MarkerState(position = userLocation.value) })
        }
        val newLocation = Location("newLocation")
        Button(
            onClick = {
                newLocation.latitude = userLocation.value.latitude
                newLocation.longitude = userLocation.value.longitude
                onLocationSelected(newLocation)
            }
        ){
            Text("Get Location")
        }

    }

}



