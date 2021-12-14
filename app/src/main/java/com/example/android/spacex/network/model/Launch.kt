package com.example.android.spacex.network.model


data class Launch(
    val dateUtc: String,
    val details: String,
    val links: Links,
    val name: String,
    val rocket: String,
    val ships: List<Any>,
    val success: Boolean,
)