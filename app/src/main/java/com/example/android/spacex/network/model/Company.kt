package com.example.android.spacex.network.model



data class Company(
    val employees: Int,
    val founded: Int,
    val founder: String,
    val launch_sites: Int,
    val name: String,
    val valuation: Long,
    val vehicles: Int
)