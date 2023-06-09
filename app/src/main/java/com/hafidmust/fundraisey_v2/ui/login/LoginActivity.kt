package com.hafidmust.fundraisey_v2.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.lifecycleScope
import com.hafidmust.fundraisey_v2.MainActivity
import com.hafidmust.fundraisey_v2.data.Result
import com.hafidmust.fundraisey_v2.data.preferences.DatastorePreferences
import com.hafidmust.fundraisey_v2.data.preferences.dataStore
import com.hafidmust.fundraisey_v2.data.request.LoginRequest
import com.hafidmust.fundraisey_v2.data.response.LoginResponse
import com.hafidmust.fundraisey_v2.data.retrofit.ApiConfig
import com.hafidmust.fundraisey_v2.databinding.ActivityLoginBinding
import com.hafidmust.fundraisey_v2.ui.ViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    //    private lateinit var viewModel : LoginViewModel
    private lateinit var pref: DatastorePreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory: ViewModelFactory = ViewModelFactory.getInstance()

        //ktx
        val viewModel: LoginViewModel by viewModels { factory }
        pref = DatastorePreferences.getInstance(application.dataStore)


        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            viewModel.login(email, password).observe(this) { result ->
                when (result) {
                    is Result.Success -> {
                        saveToken(result.data.data.accessToken)
                        startActivity(Intent(this, MainActivity::class.java))
                    }

                    is Result.Error -> Toast.makeText(this, result.error, Toast.LENGTH_SHORT).show()
                    is Result.Loading -> {}
                }
            }
        }

        //to Main Activity / dashboard
//        toMain()

    }

    private fun saveToken(token: String) {
        lifecycleScope.launch {
            pref.saveToken(token)
        }
    }

//    private fun toMain() {
//        viewModel.successLoading.observe(this) { loginSucces ->
//            if (loginSucces) {
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//            }
//        }
//    }


}