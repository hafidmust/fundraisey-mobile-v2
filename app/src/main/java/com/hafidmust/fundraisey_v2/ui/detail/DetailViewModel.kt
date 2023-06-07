package com.hafidmust.fundraisey_v2.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hafidmust.fundraisey_v2.data.response.DataDetail
import com.hafidmust.fundraisey_v2.data.response.DetailLoanResponse
import com.hafidmust.fundraisey_v2.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {
    private val _dataDetail = MutableLiveData<DataDetail>()
    val dataDetail: LiveData<DataDetail>
        get() = _dataDetail


    fun getDetailById(id : Int) {
        val client = ApiConfig.getApiService().detailLoanById(id)
        client.enqueue(object : Callback<DetailLoanResponse>{
            override fun onResponse(
                call: Call<DetailLoanResponse>,
                response: Response<DetailLoanResponse>
            ) {
                if (response.body()?.status == 200){
                    _dataDetail.value = response.body()!!.data
                }
            }

            override fun onFailure(call: Call<DetailLoanResponse>, t: Throwable) {

            }
        })
    }
}