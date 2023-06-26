package com.hafidmust.fundraisey_v2.data.source.remote.retrofit.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("data")
	val data: Data,

    @field:SerializedName("message")
	val message: String,

    @field:SerializedName("status")
	val status: Int
)

data class Data(

	@field:SerializedName("access_token")
	val accessToken: String,

	@field:SerializedName("is_enabled")
	val isEnabled: Boolean,

	@field:SerializedName("roles")
	val roles: List<String>
)
