package com.example.android.spacex.ui.repository

import com.example.android.spacex.network.ApiService
import com.example.android.spacex.network.model.CompanyAndLaunchInfo
import com.example.android.spacex.ui.repository.SpaceXRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class SpaceXRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    SpaceXRepository {

    override suspend fun getData(): CompanyAndLaunchInfo {
        return coroutineScope {
            val company = async { apiService.getCompanyInfo() }
            val launches = async { apiService.getLaunches() }
            CompanyAndLaunchInfo(company.await(), launches.await())
        }
    }
}