package com.hafidmust.fundraisey_v2.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hafidmust.fundraisey_v2.data.AuthRepository
import com.hafidmust.fundraisey_v2.di.Injection
import com.hafidmust.fundraisey_v2.ui.login.LoginViewModel

class ViewModelFactory private constructor(private val authRepository: AuthRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)){
            return LoginViewModel(authRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance : ViewModelFactory? = null
        fun getInstance() : ViewModelFactory =
            instance ?: synchronized(this){
                instance ?: ViewModelFactory((Injection.provideRepository()))
            }.also {
                instance = it
            }
    }

}