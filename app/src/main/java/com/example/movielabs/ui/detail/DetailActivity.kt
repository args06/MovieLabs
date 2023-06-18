package com.example.movielabs.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movielabs.data.model.ActorListItem
import com.example.movielabs.data.model.GenreListItem
import com.example.movielabs.data.model.MovieDetailResponse
import com.example.movielabs.databinding.ActivityDetailBinding
import com.example.movielabs.helper.Constant.EXTRA_MOVIE_ID
import com.example.movielabs.helper.Constant.EXTRA_MOVIE_TITLE
import com.example.movielabs.helper.Utils.getRuntimeFormat

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val mainViewModel by viewModels<DetailViewModel>()

    private lateinit var movieId: String
    private lateinit var movieTitle: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        movieId = intent.getStringExtra(EXTRA_MOVIE_ID).toString()
        movieTitle = intent.getStringExtra(EXTRA_MOVIE_TITLE).toString()
        title = movieTitle

        mainViewModel.getDetailMovie(movieId)

        mainViewModel.movieDetailItem.observe(this) { detailMovie ->
            setMovieData(detailMovie)
            setDetailData(detailMovie.actorList, null)
            setDetailData(null, detailMovie.genreList)
        }

        mainViewModel.isLoading.observe(this) {
            showLoading(it)
        }

    }

    private fun setMovieData(movieDetailResponse: MovieDetailResponse) {
        binding.apply {
            tvDetailTitle.text = movieDetailResponse.title
            tvDetailYear.text = movieDetailResponse.year
            tvDetailContentRating.text = movieDetailResponse.contentRating
            tvDetailRuntime.text = getRuntimeFormat(movieDetailResponse.runtimeMins)
            tvPlot.text = movieDetailResponse.plot
            Glide.with(applicationContext).load(movieDetailResponse.image).into(ivMovieDetailImage)
        }
    }

    private fun setDetailData(
        castList: List<ActorListItem>?,
        genreList: List<GenreListItem>?
    ) {
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)

            if (castList != null){
                val adapter =CastAdapter(castList)
                binding.castSection.rvCast.layoutManager = layoutManager
                binding.castSection.rvCast.adapter = adapter
            } else {
                val adapter =genreList?.let { GenreAdapter(it) }
                binding.rvGenre.layoutManager = layoutManager
                binding.rvGenre.adapter = adapter
            }

    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}