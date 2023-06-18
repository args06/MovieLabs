package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class MovieItem(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("fullTitle")
	val fullTitle: String,

	@field:SerializedName("runtimeMins")
	val runtimeMins: String,

	@field:SerializedName("year")
	val year: String,

	@field:SerializedName("directors")
	val directors: String,

	@field:SerializedName("genreList")
	val genreList: List<GenreListItem>,

	@field:SerializedName("metacriticRating")
	val metacriticRating: String,

	@field:SerializedName("directorList")
	val directorList: List<DirectorListItem>,

	@field:SerializedName("stars")
	val stars: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("imDbRating")
	val imDbRating: String,

	@field:SerializedName("runtimeStr")
	val runtimeStr: String,

	@field:SerializedName("imDbRatingCount")
	val imDbRatingCount: String,

	@field:SerializedName("plot")
	val plot: String,

	@field:SerializedName("genres")
	val genres: String,

	@field:SerializedName("contentRating")
	val contentRating: String,

	@field:SerializedName("starList")
	val starList: List<StarListItem>,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("releaseState")
	val releaseState: String
)