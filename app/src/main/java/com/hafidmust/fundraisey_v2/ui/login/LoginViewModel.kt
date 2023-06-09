package com.hafidmust.fundraisey_v2.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hafidmust.fundraisey_v2.data.AuthRepository
import com.hafidmust.fundraisey_v2.data.preferences.DatastorePreferences
import com.hafidmust.fundraisey_v2.data.request.LoginRequest
import com.hafidmust.fundraisey_v2.data.response.LoginResponse
import com.hafidmust.fundraisey_v2.data.retrofit.ApiConfig
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val authRepository: AuthRepository) : ViewModel() {
    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean>
        get() = _showLoading

    private val _successLoading = MutableLiveData<Boolean>()
    val successLoading: MutableLiveData<Boolean>
        get() = _successLoading

    fun login(email : String, password : String) = authRepository.login(email,password)

//    fun saveToken(token : String){
//        viewModelScope.launch {
//            pref.saveToken(token)
//        }
//    }
}