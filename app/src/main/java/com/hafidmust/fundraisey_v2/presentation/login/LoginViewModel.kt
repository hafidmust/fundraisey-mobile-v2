package com.hafidmust.fundraisey_v2.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hafidmust.fundraisey_v2.domain.common.Result
import com.hafidmust.fundraisey_v2.domain.model.auth.Login
import com.hafidmust.fundraisey_v2.domain.usecase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {
    private val _loginResult = MutableSharedFlow<Result<Login>>()
    val loginResult : SharedFlow<Result<Login>>
        get() = _loginResult
    fun login(email : String, password : String) = viewModelScope.launch {
        authUseCase.login(email,password).collect{
            _loginResult.emit(it)
        }
    }

//    fun saveToken(token : String){
//        viewModelScope.launch {
//            pref.saveToken(token)
//        }
//    }
}