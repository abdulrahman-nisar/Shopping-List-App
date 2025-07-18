package com.example.shoppinglistapp

data class GeoCodingResponse(
    val results: List<GeoCodingResult>,
    val status: String
)

data class GeoCodingResult(
    val formattedAddress: String
)