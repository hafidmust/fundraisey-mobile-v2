package com.hafidmust.fundraisey_v2.data.response

import com.google.gson.annotations.SerializedName

data class LoanResponse(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

data class PaymentListItem(

	@field:SerializedName("totalAmount")
	val totalAmount: Int,

	@field:SerializedName("period")
	val period: Int,

	@field:SerializedName("returnDate")
	val returnDate: String,

	@field:SerializedName("paid")
	val paid: Boolean
)

data class DataItem(

	@field:SerializedName("interestRate")
	val interestRate: Int,

	@field:SerializedName("endDate")
	val endDate: String,

	@field:SerializedName("lenderCount")
	val lenderCount: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("startupName")
	val startupName: String,

	@field:SerializedName("targetValue")
	val targetValue: Int,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("startDate")
	val startDate: String,

	@field:SerializedName("currentValue")
	val currentValue: Int,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("paymentList")
	val paymentList: List<PaymentListItem>
)
