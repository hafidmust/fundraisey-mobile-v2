package com.hafidmust.fundraisey_v2.domain.model.auth

data class Login(
	val accessToken: String,
	val isEnabled: Boolean,
	val roles: List<String>
)

