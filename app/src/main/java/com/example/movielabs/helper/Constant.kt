package com.example.movielabs.helper

import com.example.movielabs.BuildConfig

object Constant {

    const val EXTRA_MOVIE_TITLE = "extra_movie_title"
    const val EXTRA_MOVIE_ID = "extra_movie_id"
    const val API_KEY = BuildConfig.API_KEY
    val MOVIE_TYPE = arrayOf(
        "Theater",
        "ComingSoon",
    )
}