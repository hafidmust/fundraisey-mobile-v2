package com.hafidmust.fundraisey_v2.data.source.remote.retrofit

import com.hafidmust.fundraisey_v2.data.request.LoginRequest
import com.hafidmust.fundraisey_v2.data.request.RegisterRequest
import com.hafidmust.fundraisey_v2.data.source.remote.retrofit.response.DetailLoanResponse
import com.hafidmust.fundraisey_v2.data.source.remote.retrofit.response.HistoryResponse
import com.hafidmust.fundraisey_v2.data.source.remote.response.LoanResponse
import com.hafidmust.fundraisey_v2.data.source.remote.response.RegisterResponse
import com.hafidmust.fundraisey_v2.data.source.remote.retrofit.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiService {
    @POST("v1/login")
    suspend fun login(
        @Body
        dataUser: LoginRequest
    ): LoginResponse

    @POST("v1/register-investor")
    suspend fun register(
        @Body request: RegisterRequest
    ) : RegisterResponse

    @GET("v1/loan/all")
    fun getAllLoan(): Call<LoanResponse>

    @GET("v1/load/detail/{id}")
    fun detailLoanById(
        @Path("id")
        id: Int
    ): Call<DetailLoanResponse>

    @GET("/v1/investor/transaction/all?page=0&size=20&sort-by=id&sort-type=desc")
    suspend fun getHistoryLoan(
        @Header("Authorization") token: String
    ): HistoryResponse


}