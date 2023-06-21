package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class ReviewResponse(

	@field:SerializedName("imDbId")
	val imDbId: String,

	@field:SerializedName("fullTitle")
	val fullTitle: String,

	@field:SerializedName("year")
	val year: String,

	@field:SerializedName("errorMessage")
	val errorMessage: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("items")
	val items: List<ReviewItem>
)