package com.hafidmust.fundraisey_v2.utils

import com.hafidmust.fundraisey_v2.data.source.remote.response.RegisterResponse
import com.hafidmust.fundraisey_v2.data.source.remote.retrofit.response.LoginResponse
import com.hafidmust.fundraisey_v2.domain.model.auth.Login
import com.hafidmust.fundraisey_v2.domain.model.auth.Register

fun LoginResponse.toLoginDomain() = Login(
    accessToken = this.data.accessToken,
    isEnabled = this.data.isEnabled,
    roles = this.data.roles
)

fun RegisterResponse.toRegisterDomain() = Register(
    message = this.message,
    status = this.status
)