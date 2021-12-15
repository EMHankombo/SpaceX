package com.example.android.spacex.ui.repository

import com.example.android.spacex.network.model.Company
import com.example.android.spacex.network.model.CompanyAndLaunchInfo
import com.example.android.spacex.network.model.Launch

interface SpaceXRepository {

    suspend fun getData():CompanyAndLaunchInfo
}