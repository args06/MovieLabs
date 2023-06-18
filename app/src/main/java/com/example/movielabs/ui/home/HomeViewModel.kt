package com.example.movielabs.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielabs.data.model.BoxOfficeResponse
import com.example.movielabs.data.model.MovieResponse
import com.example.movielabs.data.service.MovieServiceAPI
import com.example.movielabs.helper.Constant.MOVIE_TYPE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val _theaterMovieItem = MutableLiveData<MovieResponse>()
    val theaterMovieItem: LiveData<MovieResponse> = _theaterMovieItem

    private val _comingSoonMovieItem = MutableLiveData<MovieResponse>()
    val comingSoonMovieItem: LiveData<MovieResponse> = _comingSoonMovieItem

    private val _boxOfficeMovieItem = MutableLiveData<BoxOfficeResponse>()
    val boxOfficeMovieItem: LiveData<BoxOfficeResponse> = _boxOfficeMovieItem

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getAllTheaterMovie(MOVIE_TYPE[0])
        getAllTheaterMovie(MOVIE_TYPE[1])
        getAllBoxOfficeMovie()
    }

    private fun getAllTheaterMovie(movieType: String) {
        _isLoading.value = true
        val client = if (movieType == MOVIE_TYPE[0]) MovieServiceAPI.getApiService().getTheaterMovieList()
        else MovieServiceAPI.getApiService().getComingSoonMovieList()
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>, response: Response<MovieResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    if (movieType == MOVIE_TYPE[0]) _theaterMovieItem.value = response.body()
                    else _comingSoonMovieItem.value = response.body()

                } else {
                    Log.e("Response", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e("Failure", "onFailure: ${t.message.toString()}")
            }
        })
    }

    private fun getAllBoxOfficeMovie() {
        _isLoading.value = true
        val client = MovieServiceAPI.getApiService().getBoxOfficeMovieList()
        client.enqueue(object : Callback<BoxOfficeResponse> {
            override fun onResponse(
                call: Call<BoxOfficeResponse>, response: Response<BoxOfficeResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _boxOfficeMovieItem.value = response.body()
                } else {
                    Log.e("Response", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<BoxOfficeResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e("Failure", "onFailure: ${t.message.toString()}")
            }
        })
    }

}