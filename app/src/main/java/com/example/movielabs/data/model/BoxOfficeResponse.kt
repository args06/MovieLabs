package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class BoxOfficeResponse(

	@field:SerializedName("errorMessage")
	val errorMessage: String,

	@field:SerializedName("items")
	val items: List<BoxOfficeItem>
)