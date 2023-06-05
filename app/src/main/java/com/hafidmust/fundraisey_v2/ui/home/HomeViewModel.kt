package com.hafidmust.fundraisey_v2.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hafidmust.fundraisey_v2.data.response.DataItem
import com.hafidmust.fundraisey_v2.data.response.LoanResponse
import com.hafidmust.fundraisey_v2.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val _data = MutableLiveData<List<DataItem>>()
    val data: MutableLiveData<List<DataItem>>
        get() = _data

    init {
        getAllLoan()
    }

    fun getAllLoan() {
        val client = ApiConfig.getApiService().getAllLoan()
        client.enqueue(object : Callback<LoanResponse> {
            override fun onResponse(call: Call<LoanResponse>, response: Response<LoanResponse>) {
                val res = response.body()
                if (res != null) {
                    if (res.status == 200) {
                        _data.value = res.data
                    }
                }
            }

            override fun onFailure(call: Call<LoanResponse>, t: Throwable) {

            }
        })
    }

}