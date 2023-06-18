package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class CountryListItem(

	@field:SerializedName("value")
	val value: String,

	@field:SerializedName("key")
	val key: String
)