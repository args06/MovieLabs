package com.example.movielabs.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielabs.data.model.MovieDetailResponse
import com.example.movielabs.data.model.MovieResponse
import com.example.movielabs.data.model.ReviewResponse
import com.example.movielabs.data.service.MovieServiceAPI
import com.example.movielabs.helper.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    private val _movieDetailItem = MutableLiveData<MovieDetailResponse>()
    val movieDetailItem: LiveData<MovieDetailResponse> = _movieDetailItem

    private val _reviewItem = MutableLiveData<ReviewResponse>()
    val reviewItem: LiveData<ReviewResponse> = _reviewItem

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isAllButtonClicked = MutableLiveData<Boolean>()
    val isAllButtonClicked: LiveData<Boolean> = _isAllButtonClicked

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

    fun getReviewMovie(movieId: String) {
        _isLoading.value = true
        val client = MovieServiceAPI.getApiService().getReviewList(movieId)
        client.enqueue(object : Callback<ReviewResponse> {
            override fun onResponse(
                call: Call<ReviewResponse>, response: Response<ReviewResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _reviewItem.value = response.body()
                } else {
                    Log.e("Response", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ReviewResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e("Failure", "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun setAllButtonClicked(status: Boolean) {
        _isAllButtonClicked.value = status
    }
}