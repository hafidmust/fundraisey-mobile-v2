package com.hafidmust.fundraisey_v2.domain.usecase.auth

import com.hafidmust.fundraisey_v2.domain.common.Result
import com.hafidmust.fundraisey_v2.domain.model.auth.Login
import com.hafidmust.fundraisey_v2.domain.model.auth.Register
import kotlinx.coroutines.flow.Flow

interface AuthUseCase {
    fun login(email : String, password : String) : Flow<Result<Login>>
}