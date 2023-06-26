package com.hafidmust.fundraisey_v2.data.source.remote.retrofit.response

import com.google.gson.annotations.SerializedName

data class HistoryResponse(

    @field:SerializedName("data")
	val data: DataHistory? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("status")
	val status: Int? = null
)

data class Investor(

	@field:SerializedName("profilePicture")
	val profilePicture: String? = null,

	@field:SerializedName("phoneNumber")
	val phoneNumber: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("fullName")
	val fullName: String? = null,

	@field:SerializedName("dateOfBirth")
	val dateOfBirth: String? = null,

	@field:SerializedName("bankAccountNumber")
	val bankAccountNumber: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("citizenID")
	val citizenID: String? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null
)

data class DataHistory(

    @field:SerializedName("number")
	val number: Int? = null,

    @field:SerializedName("last")
	val last: Boolean? = null,

    @field:SerializedName("size")
	val size: Int? = null,

    @field:SerializedName("numberOfElements")
	val numberOfElements: Int? = null,

    @field:SerializedName("totalPages")
	val totalPages: Int? = null,

    @field:SerializedName("pageable")
	val pageable: Pageable? = null,

    @field:SerializedName("sort")
	val sort: Sort? = null,

    @field:SerializedName("content")
	val content: List<ContentItem?>? = null,

    @field:SerializedName("first")
	val first: Boolean? = null,

    @field:SerializedName("totalElements")
	val totalElements: Int? = null,

    @field:SerializedName("empty")
	val empty: Boolean? = null
)

data class ContentItem(

    @field:SerializedName("loan")
	val loan: Loan? = null,

    @field:SerializedName("amount")
	val amount: Int? = null,

    @field:SerializedName("transactionStatus")
	val transactionStatus: String? = null,

    @field:SerializedName("created_at")
	val createdAt: String? = null,

    @field:SerializedName("paymentVerificationUrl")
	val paymentVerificationUrl: Any? = null,

    @field:SerializedName("paymentAgent")
	val paymentAgent: PaymentAgent? = null,

    @field:SerializedName("accountNumber")
	val accountNumber: String? = null,

    @field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

    @field:SerializedName("returnInstallments")
	val returnInstallments: List<Any?>? = null,

    @field:SerializedName("investor")
	val investor: Investor? = null,

    @field:SerializedName("updated_at")
	val updatedAt: String? = null,

    @field:SerializedName("paymentDeadline")
	val paymentDeadline: String? = null,

    @field:SerializedName("id")
	val id: Int? = null
)

data class PaymentPlanHistory(

	@field:SerializedName("interestRate")
	val interestRate: Any? = null,

	@field:SerializedName("totalPeriod")
	val totalPeriod: Int? = null,

	@field:SerializedName("monthInterval")
	val monthInterval: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class TransactionMethod(

	@field:SerializedName("name")
	val name: String? = null
)

data class Sort(

	@field:SerializedName("unsorted")
	val unsorted: Boolean? = null,

	@field:SerializedName("sorted")
	val sorted: Boolean? = null,

	@field:SerializedName("empty")
	val empty: Boolean? = null
)

data class StartupHistory(

	@field:SerializedName("youtube")
	val youtube: Any? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("credentials")
	val credentials: List<Any?>? = null,

	@field:SerializedName("foundedDate")
	val foundedDate: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("linkedin")
	val linkedin: Any? = null,

	@field:SerializedName("instagram")
	val instagram: Any? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("products")
	val products: List<Any?>? = null,

	@field:SerializedName("phoneNumber")
	val phoneNumber: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("web")
	val web: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("logo")
	val logo: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class Loan(

    @field:SerializedName("interestRate")
	val interestRate: Any? = null,

    @field:SerializedName("paymentPlan")
	val paymentPlan: PaymentPlanHistory? = null,

    @field:SerializedName("endDate")
	val endDate: String? = null,

    @field:SerializedName("withdrawn")
	val withdrawn: Boolean? = null,

    @field:SerializedName("created_at")
	val createdAt: String? = null,

    @field:SerializedName("description")
	val description: String? = null,

    @field:SerializedName("totalReturnPeriod")
	val totalReturnPeriod: Int? = null,

    @field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

    @field:SerializedName("loanComment")
	val loanComment: List<Any?>? = null,

    @field:SerializedName("updated_at")
	val updatedAt: String? = null,

    @field:SerializedName("startup")
	val startup: StartupHistory? = null,

    @field:SerializedName("name")
	val name: String? = null,

    @field:SerializedName("targetValue")
	val targetValue: Int? = null,

    @field:SerializedName("id")
	val id: Int? = null,

    @field:SerializedName("startDate")
	val startDate: String? = null,

    @field:SerializedName("status")
	val status: String? = null
)

data class PaymentAgent(

    @field:SerializedName("transactionMethod")
	val transactionMethod: TransactionMethod? = null,

    @field:SerializedName("name")
	val name: String? = null,

    @field:SerializedName("id")
	val id: Int? = null
)

data class Pageable(

	@field:SerializedName("paged")
	val paged: Boolean? = null,

	@field:SerializedName("pageNumber")
	val pageNumber: Int? = null,

	@field:SerializedName("offset")
	val offset: Int? = null,

	@field:SerializedName("pageSize")
	val pageSize: Int? = null,

	@field:SerializedName("unpaged")
	val unpaged: Boolean? = null,

	@field:SerializedName("sort")
	val sort: Sort? = null
)
