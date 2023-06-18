package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class WriterListItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String
)