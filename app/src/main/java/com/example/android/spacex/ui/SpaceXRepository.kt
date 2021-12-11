package com.example.android.spacex.ui

import com.example.android.spacex.network.model.Company
import com.example.android.spacex.network.model.Launch

interface SpaceXRepository {

    suspend fun getCompanyInfo():Company

    suspend fun getLaunches():List<Launch>
}