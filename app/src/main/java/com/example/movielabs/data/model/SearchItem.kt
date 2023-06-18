package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class SearchItem(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("resultType")
	val resultType: String
)