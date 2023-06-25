package com.hafidmust.fundraisey_v2.domain.usecase.auth

import com.hafidmust.fundraisey_v2.domain.common.Result
import com.hafidmust.fundraisey_v2.domain.model.auth.Login
import com.hafidmust.fundraisey_v2.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthInteractor @Inject constructor(private val authRepository: AuthRepository) : AuthUseCase {


    override fun login(email: String, password: String): Flow<Result<Login>> {
        return authRepository.login(email, password)
    }
}