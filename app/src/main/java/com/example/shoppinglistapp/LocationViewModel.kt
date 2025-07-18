package com.example.shoppinglistapp

import android.location.Location
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.maps.android.ktx.BuildConfig
import kotlinx.coroutines.launch

class locationViewModel : ViewModel() {
    private val _location = mutableStateOf<Location?>(null)
    val location: State<Location?> = _location

    private val _address = mutableStateOf((listOf<GeoCodingResult>()))
    val address: State<List<GeoCodingResult>> = _address

    fun updateLocation(newLocation: Location) {
        _location.value = newLocation

    }


    fun fetchAddress(latlng: String) {

        try {
            viewModelScope.launch {
                val result = RetrofitClient.create().getAddressFromCoordinates(
                    latlng,
                    "AIzaSyACT9lHZYI_-edGAc5NK3JdvrP_nlNGAqw"
                )
            }
        } catch (e: Exception) {
            print(e)
        }
    }
}