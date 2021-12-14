package com.example.android.spacex.network.model


data class Core(
    val core: String,
    val flight: Int,
    val gridfins: Boolean,
    val landingAttempt: Boolean,
    val landingSuccess: Any,
    val landingType: Any,
    val landpad: Any,
    val legs: Boolean,
    val reused: Boolean
)