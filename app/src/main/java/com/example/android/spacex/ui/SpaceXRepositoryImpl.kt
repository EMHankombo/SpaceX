package com.example.android.spacex.ui

import com.example.android.spacex.network.ApiService
import com.example.android.spacex.network.model.Company
import com.example.android.spacex.network.model.CompanyAndLaunchInfo
import com.example.android.spacex.network.model.Launch
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class SpaceXRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    SpaceXRepository {

    override suspend fun getCompanyInfo(): Company {
        return apiService.getCompanyInfo()
    }

    override suspend fun getLaunches(): List<Launch> {
        return apiService.getLaunches()
    }

    override suspend fun getData(): CompanyAndLaunchInfo {
        return coroutineScope {
            val company = async { apiService.getCompanyInfo() }
            val launches = async { apiService.getLaunches() }
            CompanyAndLaunchInfo(company.await(), launches.await())
        }
    }
}