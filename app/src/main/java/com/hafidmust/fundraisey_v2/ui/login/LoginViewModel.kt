package com.hafidmust.fundraisey_v2.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hafidmust.fundraisey_v2.data.request.LoginRequest
import com.hafidmust.fundraisey_v2.data.response.LoginResponse
import com.hafidmust.fundraisey_v2.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean>
        get() = _showLoading

    private val _successLoading = MutableLiveData<Boolean>()
    val successLoading: MutableLiveData<Boolean>
        get() = _successLoading

    fun login(email: String, password: String) {
        //loading
        val client = ApiConfig.getApiService().login(
            LoginRequest(
                email = email,
                password = password,
                grantType = "password",
                clientId = "client-web",
                clientSecret = "password"
            )
        )
        client.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val data = response.body()
                if (data?.status == 200) {
                    //berhasil
                    //data.data.accessToken.let { Log.d("login berhasil", it) }
                    _successLoading.value = true

                } else if (data?.status == 400) {
                    //message error
                    Log.e("login gagal response : ", data.message)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("login onFailure : ", t.message.toString())
            }
        })
    }
}