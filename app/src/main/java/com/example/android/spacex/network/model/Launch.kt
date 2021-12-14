package com.example.android.spacex.network.model


data class Launch(
    val autoUpdate: Boolean,
    val capsules: List<Any>,
    val cores: List<Core>,
    val crew: List<Any>,
    val dateLocal: String,
    val datePrecision: String,
    val dateUnix: Int,
    val dateUtc: String,
    val details: String,
    val failures: List<Failure>,
    val fairings: Fairings,
    val flightNumber: Int,
    val id: String,
    val launchLibraryId: Any,
    val launchpad: String,
    val links: Links,
    val name: String,
    val net: Boolean,
    val payloads: List<String>,
    val rocket: String,
    val ships: List<Any>,
    val staticFireDateUnix: Int,
    val staticFireDateUtc: String,
    val success: Boolean,
    val tbd: Boolean,
    val upcoming: Boolean,
    val window: Int
)