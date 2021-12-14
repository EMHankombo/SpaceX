package com.example.android.spacex.network.model



data class Company(
    val employees: Int,
    val founded: Int,
    val founder: String,
    val launchSites: Int,
    val name: String,
    val valuation: Long,
    val vehicles: Int
)