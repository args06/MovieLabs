package com.example.movielabs.data.service

import com.example.movielabs.data.model.*
import com.example.movielabs.helper.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieAPI {

    @GET("InTheaters/${Constant.API_KEY}")
    fun getTheaterMovieList(): Call<MovieResponse>

    @GET("ComingSoon/${Constant.API_KEY}")
    fun getComingSoonMovieList(): Call<MovieResponse>

    @GET("BoxOffice/${Constant.API_KEY}")
    fun getBoxOfficeMovieList(): Call<BoxOfficeResponse>

    @GET("Title/${Constant.API_KEY}/{movieId}")
    fun getDetailMovieList(@Path("movieId") movieId : String): Call<MovieDetailResponse>

    @GET("SearchMovie/${Constant.API_KEY}/{keyword}")
    fun getSearchList(@Path("keyword") keyword : String): Call<SearchResponse>

    @GET("Reviews/${Constant.API_KEY}/{movieId}")
    fun getReviewList(@Path("movieId") movieId : String): Call<ReviewResponse>
}