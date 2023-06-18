package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(

	@field:SerializedName("expression")
	val expression: String,

	@field:SerializedName("searchType")
	val searchType: String,

	@field:SerializedName("errorMessage")
	val errorMessage: String,

	@field:SerializedName("results")
	val results: List<SearchItem>
)