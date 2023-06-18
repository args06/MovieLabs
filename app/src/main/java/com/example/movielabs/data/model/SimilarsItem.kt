package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class SimilarsItem(

	@field:SerializedName("imDbRating")
	val imDbRating: String,

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("title")
	val title: String
)