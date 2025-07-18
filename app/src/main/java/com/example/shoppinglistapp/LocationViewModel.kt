package com.example.shoppinglistapp

import android.location.Location
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LocationViewModel : ViewModel() {
    private val _location = mutableStateOf<Location?>(null)
    val location: State<Location?> = _location

    fun updateLocation(newLocation: Location) {
        _location.value = newLocation

    }
}