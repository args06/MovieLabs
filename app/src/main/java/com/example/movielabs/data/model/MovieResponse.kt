package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(

	@field:SerializedName("errorMessage")
	val errorMessage: String,

	@field:SerializedName("items")
	val items: List<MovieItem>
)