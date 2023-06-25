package com.hafidmust.fundraisey_v2.domain.repository

import com.hafidmust.fundraisey_v2.domain.common.Result
import com.hafidmust.fundraisey_v2.domain.model.auth.Login
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(email : String, password : String) : Flow<Result<Login>>
}