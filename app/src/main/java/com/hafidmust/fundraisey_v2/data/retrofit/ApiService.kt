package com.hafidmust.fundraisey_v2.data.retrofit

import com.hafidmust.fundraisey_v2.data.request.LoginRequest
import com.hafidmust.fundraisey_v2.data.response.DetailLoanResponse
import com.hafidmust.fundraisey_v2.data.response.LoanResponse
import com.hafidmust.fundraisey_v2.data.response.LoginResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiService {
    @POST("v1/login")
    fun login(
        @Body
        dataUser : LoginRequest
    ) : Call<LoginResponse>

    @GET("v1/loan/all")
    fun getAllLoan() : Call<LoanResponse>

    @GET("v1/load/detail/{id}")
    fun detailLoanById(
        @Path("id")
        id : Int
    ) : Call<DetailLoanResponse>

}