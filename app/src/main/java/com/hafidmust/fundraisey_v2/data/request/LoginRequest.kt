package com.hafidmust.fundraisey_v2.data.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("grant_type")
	val grantType: String,

	@field:SerializedName("client_secret")
	val clientSecret: String,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("client_id")
	val clientId: String
)
