package com.hafidmust.fundraisey_v2.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.hafidmust.fundraisey_v2.data.AuthRepository
import com.hafidmust.fundraisey_v2.data.preferences.DatastorePreferences
import com.hafidmust.fundraisey_v2.data.retrofit.ApiConfig

object Injection {
    fun provideRepository() : AuthRepository {
        val apiService = ApiConfig.getApiService()

        return AuthRepository.getInstance(apiService)
    }
}