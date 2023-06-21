package com.example.movielabs.ui.detail

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movielabs.R
import com.example.movielabs.data.model.ActorListItem
import com.example.movielabs.data.model.GenreListItem
import com.example.movielabs.data.model.MovieDetailResponse
import com.example.movielabs.data.model.ReviewItem
import com.example.movielabs.databinding.ActivityDetailBinding
import com.example.movielabs.helper.Constant.EXTRA_MOVIE_ID
import com.example.movielabs.helper.Constant.EXTRA_MOVIE_TITLE
import com.example.movielabs.helper.Utils
import com.example.movielabs.helper.Utils.getRuntimeFormat

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val mainViewModel by viewModels<DetailViewModel>()

    private lateinit var movieId: String
    private lateinit var movieTitle: String

    private var isAllButtonClicked: Boolean = false
    private lateinit var movieReview: List<ReviewItem>

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
        mainViewModel.getReviewMovie(movieId)

        binding.reviewSection.tvSeeAll.setOnClickListener {
            mainViewModel.setAllButtonClicked(!isAllButtonClicked)
        }

        mainViewModel.movieDetailItem.observe(this) { detailMovie ->
            setMovieData(detailMovie)
            setDetailData(detailMovie.actorList, null)
            setDetailData(null, detailMovie.genreList)
        }

        mainViewModel.isAllButtonClicked.observe(this) { isAllButtonClicked ->
            this.isAllButtonClicked = isAllButtonClicked
            if (isAllButtonClicked) {
                setReviewData(movieReview)
                binding.reviewSection.tvSeeAll.text = getString(R.string.see_less)
                binding.reviewSection.tvSeeAll.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    R.drawable.baseline_keyboard_arrow_up_24,
                    0,
                    0
                )
            } else {
                setReviewData(movieReview.take(10))
                binding.reviewSection.tvSeeAll.text = getString(R.string.see_all)
                binding.reviewSection.tvSeeAll.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    0,
                    R.drawable.baseline_keyboard_arrow_down_24
                )
            }
        }

        mainViewModel.reviewItem.observe(this) { movieReview ->
            this.movieReview = movieReview.items
            if (isAllButtonClicked) {
                setReviewData(movieReview.items)
            } else {
                setReviewData(movieReview.items.take(10))
            }
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
            tvFullRating.text = Utils.getFullRatingReview(movieDetailResponse.imDbRating)
            tvMetaScore.text = movieDetailResponse.metacriticRating
            Glide.with(applicationContext).load(movieDetailResponse.image).into(ivMovieDetailImage)
            reviewSection.tvReviewAverageRating.text = Utils.getFullRatingReview(movieDetailResponse.imDbRating)
        }
    }

    private fun setDetailData(
        castList: List<ActorListItem>?,
        genreList: List<GenreListItem>?
    ) {
        val layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)

        if (castList != null) {
            val adapter = CastAdapter(castList)
            binding.castSection.rvCast.layoutManager = layoutManager
            binding.castSection.rvCast.adapter = adapter
        } else {
            val adapter = genreList?.let { GenreAdapter(it) }
            binding.rvGenre.layoutManager = layoutManager
            binding.rvGenre.adapter = adapter
        }

    }

    private fun setReviewData(
        reviewList: List<ReviewItem>,
    ) {
        val adapter = ReviewAdapter(reviewList)
        val layoutManager =
            LinearLayoutManager(applicationContext)
        binding.reviewSection.rvReview.layoutManager = layoutManager
        binding.reviewSection.rvReview.adapter = adapter
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