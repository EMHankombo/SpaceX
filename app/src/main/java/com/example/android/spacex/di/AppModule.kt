package com.example.android.spacex.di

import com.example.android.spacex.BASE_URL
import com.example.android.spacex.network.ApiService
import com.example.android.spacex.ui.SpaceXRepository
import com.example.android.spacex.ui.SpaceXRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSpaceXRepository(apiService: ApiService): SpaceXRepository {
        return SpaceXRepositoryImpl(apiService)
    }
}