package com.example.movielabs.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielabs.R
import com.example.movielabs.data.model.ReviewItem
import com.example.movielabs.databinding.ReviewItemBinding
import com.example.movielabs.helper.Utils

class ReviewAdapter(private val reviewList: List<ReviewItem>) : RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {

    class ViewHolder(var binding: ReviewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ReviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = reviewList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reviewItem = reviewList[position]
        holder.binding.apply {
            tvReviewItemRating.text = Utils.getFullRatingReview(reviewItem.rate)
            if (reviewItem.warningSpoilers)
                cvSpoilerCard.visibility = View.VISIBLE
            else
                cvSpoilerCard.visibility = View.GONE
            tvReviewItemTitle.text = reviewItem.title
            tvReviewItemUsername.text = reviewItem.username
            tvReviewItemDate.text = reviewItem.date
            tvReviewItemContent.text = reviewItem.content

            var isSeeAllButtonClicked = false

            tvReviewItemSeeAll.setOnClickListener {
                if (isSeeAllButtonClicked) {
                    isSeeAllButtonClicked = false
                    tvReviewItemContent.maxLines = 5
                    tvReviewItemSeeAll.text = it.context.getString(R.string.see_more)
                }
                else {
                    isSeeAllButtonClicked = true
                    tvReviewItemContent.maxLines = Integer.MAX_VALUE
                    tvReviewItemSeeAll.text = it.context.getString(R.string.see_less)
                }
            }

        }
    }
}