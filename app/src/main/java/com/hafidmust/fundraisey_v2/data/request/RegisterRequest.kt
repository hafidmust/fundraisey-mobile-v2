package com.hafidmust.fundraisey_v2.data.request

import com.google.gson.annotations.SerializedName

data class RegisterRequest(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("phoneNumber")
	val phoneNumber: String,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("fullName")
	val fullName: String,

	@field:SerializedName("dateOfBirth")
	val dateOfBirth: String,

	@field:SerializedName("citizenID")
	val citizenID: String,

	@field:SerializedName("email")
	val email: String
)
