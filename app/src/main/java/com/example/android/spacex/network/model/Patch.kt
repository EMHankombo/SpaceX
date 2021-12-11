package com.example.android.spacex.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Patch(
    @Json(name = "large")
    val large: String,
    @Json(name = "small")
    val small: String
)