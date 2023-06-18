package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class BoxOffice(

	@field:SerializedName("grossUSA")
	val grossUSA: String,

	@field:SerializedName("openingWeekendUSA")
	val openingWeekendUSA: String,

	@field:SerializedName("cumulativeWorldwideGross")
	val cumulativeWorldwideGross: String,

	@field:SerializedName("budget")
	val budget: String
)