package com.hafidmust.fundraisey_v2.presentation.history

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hafidmust.fundraisey_v2.data.source.remote.retrofit.response.ContentItem
import com.hafidmust.fundraisey_v2.data.source.remote.retrofit.ApiConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryViewModel : ViewModel() {

    private val _listHistory = MutableLiveData<List<ContentItem>?>()
    val listHistory: LiveData<List<ContentItem>?>
        get() = _listHistory

    init {
        getHistory()
    }

    fun getHistory() {
        viewModelScope.launch(Dispatchers.IO) {
            val token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib2F1dGgyLXJlc291cmNlIl0sInVzZXJfbmFtZSI6ImludmVzdG9yQGZ1bmRyYWlzZXkuY29tIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTY4NzI4NjExMiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9JTlZFU1RPUiJdLCJqdGkiOiI1NzM5NjUyOS0yODkxLTRjMmYtYjg4Zi02OTZkMTFlMGVhMzciLCJjbGllbnRfaWQiOiJjbGllbnQtd2ViIn0.ePdR2NPpUzTPKkhTg8Gvqi0pCL75QQF1jYbAx_EW75M"
            val client = ApiConfig.getApiService().getHistoryLoan(token)
            try {
                if (client.data != null) {
                    _listHistory.postValue(client.data.content as List<ContentItem>?)
                }
            } catch (e: Exception) {
                Log.e("HistoryViewModel", e.printStackTrace().toString())
            }
        }
    }

//    private fun getHistory() {
//        val token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib2F1dGgyLXJlc291cmNlIl0sInVzZXJfbmFtZSI6ImludmVzdG9yQGZ1bmRyYWlzZXkuY29tIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTY4NzE2Mzc0NSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9JTlZFU1RPUiJdLCJqdGkiOiJmZjA1MGEyMC1lNmIxLTQxMTktOTcxNy04NjM1MDQxMGE4MmEiLCJjbGllbnRfaWQiOiJjbGllbnQtd2ViIn0.fluk-S9TNvhjETV91n7lGkS1Iopw4URudLdREua2QF0"
//        val client = ApiConfig.getApiService().getHistoryLoan(token)
//        client.enqueue(object : Callback<HistoryResponse>{
//            override fun onResponse(
//                call: Call<HistoryResponse>,
//                response: Response<HistoryResponse>
//            ) {
//                val res = response.body()
//                if (response.isSuccessful){
//                    _listHistory.value = res?.data?.content as List<ContentItem>?
//                }
//            }
//
//            override fun onFailure(call: Call<HistoryResponse>, t: Throwable) {
//
//            }
//        })
//    }

}