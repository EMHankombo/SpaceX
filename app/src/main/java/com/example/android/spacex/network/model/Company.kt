package com.example.android.spacex.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Company(
    @Json(name = "employees")
    val employees: Int,
    @Json(name = "founded")
    val founded: Int,
    @Json(name = "founder")
    val founder: String,
    @Json(name = "launch_sites")
    val launchSites: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "valuation")
    val valuation: Long,
    @Json(name = "vehicles")
    val vehicles: Int
)