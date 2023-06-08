package com.hafidmust.fundraisey_v2.di

import com.hafidmust.fundraisey_v2.data.AuthRepository
import com.hafidmust.fundraisey_v2.data.retrofit.ApiConfig

object Injection {
    fun provideRepository() : AuthRepository {
        val apiService = ApiConfig.getApiService()

        return AuthRepository.getInstance(apiService)
    }
}