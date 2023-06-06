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

data class PaymentPlan(

	@field:SerializedName("interestRate")
	val interestRate: Any,

	@field:SerializedName("totalPeriod")
	val totalPeriod: Int,

	@field:SerializedName("monthInterval")
	val monthInterval: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class Startup(

	@field:SerializedName("youtube")
	val youtube: Any,

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("credentials")
	val credentials: List<Any>,

	@field:SerializedName("foundedDate")
	val foundedDate: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("linkedin")
	val linkedin: Any,

	@field:SerializedName("instagram")
	val instagram: Any,

	@field:SerializedName("deleted_at")
	val deletedAt: Any,

	@field:SerializedName("products")
	val products: List<Any>,

	@field:SerializedName("phoneNumber")
	val phoneNumber: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("web")
	val web: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("logo")
	val logo: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("email")
	val email: String
)

data class DataItem(

	@field:SerializedName("interestRate")
	val interestRate: Any,

	@field:SerializedName("paymentPlan")
	val paymentPlan: PaymentPlan,

	@field:SerializedName("endDate")
	val endDate: String,

	@field:SerializedName("lenderCount")
	val lenderCount: Int,

	@field:SerializedName("withdrawn")
	val withdrawn: Boolean,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("paymentList")
	val paymentList: List<PaymentListItem>,

	@field:SerializedName("startup")
	val startup: Startup,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("targetValue")
	val targetValue: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("startDate")
	val startDate: String,

	@field:SerializedName("currentValue")
	val currentValue: Int,

	@field:SerializedName("status")
	val status: String
)

data class PaymentListItem(

	@field:SerializedName("interestRate")
	val interestRate: Any,

	@field:SerializedName("totalAmount")
	val totalAmount: Int,

	@field:SerializedName("period")
	val period: Int,

	@field:SerializedName("returnDate")
	val returnDate: String,

	@field:SerializedName("paid")
	val paid: Boolean,

	@field:SerializedName("platformFeeRate")
	val platformFeeRate: Any,

	@field:SerializedName("platformFee")
	val platformFee: Int
)
