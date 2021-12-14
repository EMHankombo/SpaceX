package com.example.android.spacex.network.model


data class Fairings(
    val recovered: Boolean,
    val recoveryAttempt: Boolean,
    val reused: Boolean,
    val ships: List<Any>
)