package com.hafidmust.fundraisey_v2.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hafidmust.fundraisey_v2.domain.common.Result
import com.hafidmust.fundraisey_v2.domain.model.auth.Register
import com.hafidmust.fundraisey_v2.domain.usecase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {


    private val _registerResult = MutableSharedFlow<Result<Register>>()
    val registerResult : SharedFlow<Result<Register>>
        get() = _registerResult

    fun register(email : String, password : String) {
        viewModelScope.launch {
            authUseCase.register(
                email = email,
                password = password,
                citizenId = "1234567890123456",
                fullName = "zzz",
                gender = "male",
                phoneNumber = "1234567890123",
                dateOfBirth = "2000-01-01"
            ).collect{
                _registerResult.emit(it)
            }
        }
    }
}