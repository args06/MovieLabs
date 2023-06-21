package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class ReviewItem(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("warningSpoilers")
	val warningSpoilers: Boolean,

	@field:SerializedName("reviewLink")
	val reviewLink: String,

	@field:SerializedName("rate")
	val rate: String,

	@field:SerializedName("helpful")
	val helpful: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("userUrl")
	val userUrl: String,

	@field:SerializedName("content")
	val content: String,

	@field:SerializedName("username")
	val username: String
)