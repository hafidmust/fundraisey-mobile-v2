package com.hafidmust.fundraisey_v2.data.source.remote

import com.hafidmust.fundraisey_v2.data.request.LoginRequest
import com.hafidmust.fundraisey_v2.data.request.RegisterRequest
import com.hafidmust.fundraisey_v2.data.source.remote.retrofit.ApiService
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun login(email: String, password: String) =
        apiService.login(
            LoginRequest(
                password = password,
                email = email,
                grantType = "password",
                clientSecret = "password",
                clientId = "client-web"
            )
        )

    suspend fun register(
        email: String,
        password: String,
        citizenId: String,
        fullName: String,
        gender: String,
        phoneNumber: String,
        dateOfBirth: String
    ) =
        apiService.register(
            RegisterRequest(
                email = email,
                password = password,
                citizenID = citizenId,
                fullName = fullName,
                gender = gender,
                phoneNumber = phoneNumber,
                dateOfBirth = dateOfBirth
            )
        )
}