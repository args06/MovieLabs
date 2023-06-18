package com.example.movielabs.data.model

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(

    @field:SerializedName("keywords")
	val keywords: String,

    @field:SerializedName("year")
	val year: String,

    @field:SerializedName("directors")
	val directors: String,

    @field:SerializedName("genreList")
	val genreList: List<GenreListItem>,

    @field:SerializedName("title")
	val title: String,

    @field:SerializedName("type")
	val type: String,

    @field:SerializedName("tvEpisodeInfo")
	val tvEpisodeInfo: Any,

    @field:SerializedName("imDbRating")
	val imDbRating: String,

    @field:SerializedName("trailer")
	val trailer: Any,

    @field:SerializedName("runtimeStr")
	val runtimeStr: String,

    @field:SerializedName("plotLocal")
	val plotLocal: String,

    @field:SerializedName("companies")
	val companies: String,

    @field:SerializedName("plot")
	val plot: String,

    @field:SerializedName("companyList")
	val companyList: List<CompanyListItem>,

    @field:SerializedName("genres")
	val genres: String,

    @field:SerializedName("ratings")
	val ratings: Any,

    @field:SerializedName("actorList")
	val actorList: List<ActorListItem>,

    @field:SerializedName("imDbRatingVotes")
	val imDbRatingVotes: String,

    @field:SerializedName("tvSeriesInfo")
	val tvSeriesInfo: Any,

    @field:SerializedName("id")
	val id: String,

    @field:SerializedName("languageList")
	val languageList: List<LanguageListItem>,

    @field:SerializedName("wikipedia")
	val wikipedia: Any,

    @field:SerializedName("fullCast")
	val fullCast: Any,

    @field:SerializedName("image")
	val image: String,

    @field:SerializedName("fullTitle")
	val fullTitle: String,

    @field:SerializedName("images")
	val images: Any,

    @field:SerializedName("runtimeMins")
	val runtimeMins: String,

    @field:SerializedName("languages")
	val languages: String,

    @field:SerializedName("releaseDate")
	val releaseDate: String,

    @field:SerializedName("similars")
	val similars: List<SimilarsItem>,

    @field:SerializedName("posters")
	val posters: Any,

    @field:SerializedName("errorMessage")
	val errorMessage: String,

    @field:SerializedName("metacriticRating")
	val metacriticRating: String,

    @field:SerializedName("directorList")
	val directorList: List<DirectorListItem>,

    @field:SerializedName("writers")
	val writers: String,

    @field:SerializedName("stars")
	val stars: String,

    @field:SerializedName("countries")
	val countries: String,

    @field:SerializedName("countryList")
	val countryList: List<CountryListItem>,

    @field:SerializedName("plotLocalIsRtl")
	val plotLocalIsRtl: Boolean,

    @field:SerializedName("keywordList")
	val keywordList: List<String>,

    @field:SerializedName("originalTitle")
	val originalTitle: String,

    @field:SerializedName("awards")
	val awards: String,

    @field:SerializedName("tagline")
	val tagline: Any,

    @field:SerializedName("starList")
	val starList: List<StarListItem>,

    @field:SerializedName("contentRating")
	val contentRating: String,

    @field:SerializedName("boxOffice")
	val boxOffice: BoxOffice,

    @field:SerializedName("writerList")
	val writerList: List<WriterListItem>
)