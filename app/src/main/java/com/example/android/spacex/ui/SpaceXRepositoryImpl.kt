package com.example.android.spacex.ui

import com.example.android.spacex.network.ApiService
import com.example.android.spacex.network.model.Company
import com.example.android.spacex.network.model.Launch
import javax.inject.Inject

class SpaceXRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    SpaceXRepository {

    override suspend fun getCompanyInfo(): Company {
        return apiService.getCompanyInfo()
    }

    override suspend fun getLaunches(): List<Launch> {
        return apiService.getLaunches()
    }
}