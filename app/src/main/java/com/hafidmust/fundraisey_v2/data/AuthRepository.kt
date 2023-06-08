package com.hafidmust.fundraisey_v2.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.hafidmust.fundraisey_v2.data.request.LoginRequest
import com.hafidmust.fundraisey_v2.data.response.LoginResponse
import com.hafidmust.fundraisey_v2.data.retrofit.ApiConfig
import com.hafidmust.fundraisey_v2.data.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository private constructor(
    private val apiService: ApiService
){
    private val result = MediatorLiveData<Result<LoginResponse>>()
    fun login(email : String, password : String) : LiveData<Result<LoginResponse>> {
//        result.value = Result.Loading
        val request = LoginRequest(
            email = email,
            password = password,
            grantType = "password",
            clientSecret = "password",
            clientId = "client-web"
        )
        val client = apiService.login(request)
        client.enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val data = response.body()
                if (data?.status == 200) {
                    //berhasil
                    //data.data.accessToken.let { Log.d("login berhasil", it) }
                    result.value = Result.Success(data)


                } else {
                    //message error
                    result.value = Result.Error("Email atau password salah")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("login onFailure : ", t.message.toString())
            }
        })
        return result
    }

    companion object {
        @Volatile
        private var instance : AuthRepository? = null
        fun getInstance(
            apiService: ApiService
        ) : AuthRepository =
            instance ?: synchronized(this){
                instance ?: AuthRepository(apiService)
            }.also { instance = it }
    }
}