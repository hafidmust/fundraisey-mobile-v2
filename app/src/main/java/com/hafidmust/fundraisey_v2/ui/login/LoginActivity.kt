package com.hafidmust.fundraisey_v2.ui.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hafidmust.fundraisey_v2.data.request.LoginRequest
import com.hafidmust.fundraisey_v2.data.response.LoginResponse
import com.hafidmust.fundraisey_v2.data.retrofit.ApiConfig
import com.hafidmust.fundraisey_v2.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            login(email, password)
        }
    }

    private fun login(email: String, password: String) {
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
                if (data?.status == 200){
                    //berhasil
                    data.data.accessToken.let { Log.d("login berhasil", it) }
                }else if (data?.status == 400){
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