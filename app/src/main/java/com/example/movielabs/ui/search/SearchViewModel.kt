package com.example.movielabs.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielabs.data.model.MovieDetailResponse
import com.example.movielabs.data.model.SearchResponse
import com.example.movielabs.data.service.MovieServiceAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {

    private val _searchItem = MutableLiveData<SearchResponse>()
    val searchItem: LiveData<SearchResponse> = _searchItem

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getSearchMovie(keyword: String) {
        _isLoading.value = true
        val client = MovieServiceAPI.getApiService().getSearchList(keyword)
        client.enqueue(object : Callback<SearchResponse> {
            override fun onResponse(
                call: Call<SearchResponse>, response: Response<SearchResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _searchItem.value = response.body()
                } else {
                    Log.e("Response", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e("Failure", "onFailure: ${t.message.toString()}")
            }
        })
    }
}