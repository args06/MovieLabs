package com.example.movielabs.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielabs.data.model.MovieDetailResponse
import com.example.movielabs.data.model.MovieResponse
import com.example.movielabs.data.service.MovieServiceAPI
import com.example.movielabs.helper.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    private val _movieDetailItem = MutableLiveData<MovieDetailResponse>()
    val movieDetailItem: LiveData<MovieDetailResponse> = _movieDetailItem

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getDetailMovie(movieId: String) {
        _isLoading.value = true
        val client = MovieServiceAPI.getApiService().getDetailMovieList(movieId)
        client.enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(
                call: Call<MovieDetailResponse>, response: Response<MovieDetailResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _movieDetailItem.value = response.body()
                } else {
                    Log.e("Response", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e("Failure", "onFailure: ${t.message.toString()}")
            }
        })
    }
}