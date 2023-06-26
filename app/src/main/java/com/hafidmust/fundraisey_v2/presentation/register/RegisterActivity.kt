package com.hafidmust.fundraisey_v2.presentation.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hafidmust.fundraisey_v2.R
import com.hafidmust.fundraisey_v2.databinding.ActivityRegisterBinding
import com.hafidmust.fundraisey_v2.domain.common.Result
import com.hafidmust.fundraisey_v2.presentation.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val viewModel by viewModels<RegisterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            viewModel.register(email,password)

            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.CREATED){
                    viewModel.registerResult.collect{result ->
                        when(result){
                            is Result.Error -> {
                                Toast.makeText(this@RegisterActivity,result.message,Toast.LENGTH_SHORT).show()
                            }
                            is Result.Loading -> {

                            }
                            is Result.Success -> {
                                toLogin()
                            }
                        }
                    }
                }
            }
        }

        binding.tvHaveAcc.setOnClickListener {
            startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
        }

    }


    private fun toLogin() {
        val intentLogin = Intent(this@RegisterActivity,LoginActivity::class.java)
        startActivity(intentLogin)
    }

}