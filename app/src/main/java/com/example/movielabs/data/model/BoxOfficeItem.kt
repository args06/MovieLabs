package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class BoxOfficeItem(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("weeks")
	val weeks: String,

	@field:SerializedName("gross")
	val gross: String,

	@field:SerializedName("weekend")
	val weekend: String,

	@field:SerializedName("rank")
	val rank: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("title")
	val title: String
)