package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class ActorListItem(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("asCharacter")
	val asCharacter: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String
)