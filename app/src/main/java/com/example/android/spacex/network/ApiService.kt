package com.example.android.spacex.network

import com.example.android.spacex.network.model.Company
import com.example.android.spacex.network.model.Launch
import retrofit2.http.GET

interface ApiService {

    @GET("company")
    suspend fun getCompanyInfo():Company

    @GET("launches")
    suspend fun getLaunches():List<Launch>
}