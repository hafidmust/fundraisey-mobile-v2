package com.hafidmust.fundraisey_v2.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hafidmust.fundraisey_v2.MainActivity
import com.hafidmust.fundraisey_v2.data.preferences.DatastorePreferences
import com.hafidmust.fundraisey_v2.data.preferences.dataStore
import com.hafidmust.fundraisey_v2.databinding.ActivityLoginBinding
import com.hafidmust.fundraisey_v2.presentation.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    //    private lateinit var viewModel : LoginViewModel
    private lateinit var pref: DatastorePreferences
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //ktx
        pref = DatastorePreferences.getInstance(application.dataStore)


        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            viewModel.login(email,password)


            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.CREATED) {
                    viewModel.loginResult.collect { result ->
                        when (result) {
                            is com.hafidmust.fundraisey_v2.domain.common.Result.Error -> {

                            }

                            is com.hafidmust.fundraisey_v2.domain.common.Result.Loading -> {

                            }

                            is com.hafidmust.fundraisey_v2.domain.common.Result.Success -> {
                                toMain()
                            }
                        }

                    }
                }
            }
        }

        binding.tvDontHaveAcc.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }

        //to Main Activity / dashboard
//        toMain()

    }

    private fun saveToken(token: String) {
        lifecycleScope.launch {
            pref.saveToken(token)
        }
    }

    private fun toMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}