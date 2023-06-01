package com.hafidmust.fundraisey_v2.data.retrofit

import com.hafidmust.fundraisey_v2.data.request.LoginRequest
import com.hafidmust.fundraisey_v2.data.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("v1/login")
    fun login(
        @Body
        dataUser : LoginRequest
    ) : Call<LoginResponse>
}