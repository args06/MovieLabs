package com.example.movielabs.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielabs.data.model.MovieItem
import com.example.movielabs.databinding.ComingSoonItemBinding
import com.example.movielabs.helper.Constant
import com.example.movielabs.helper.Utils
import com.example.movielabs.ui.detail.DetailActivity

class ComingSoonAdapter(private val listMovie: List<MovieItem>) : RecyclerView.Adapter<ComingSoonAdapter.ViewHolder>() {

    class ViewHolder(var binding: ComingSoonItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ComingSoonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieItem = listMovie[position]
        holder.binding.apply {
            Glide.with(holder.itemView.context).load(movieItem.image).into(ivMovieImage)
            tvReleaseDate.text = movieItem.releaseState
            tvRating.text = movieItem.imDbRating
            tvTitle.text = movieItem.title
            tvYear.text = movieItem.year
            tvContentRating.text = movieItem.contentRating
            tvRuntime.text = Utils.getRuntimeFormat(movieItem.runtimeMins)
            clComingSoonItem.setOnClickListener() {
                val moveIntent = Intent(it.context, DetailActivity::class.java)
                moveIntent.putExtra(Constant.EXTRA_MOVIE_ID, movieItem.id)
                moveIntent.putExtra(Constant.EXTRA_MOVIE_TITLE, movieItem.title)
                it.context.startActivity(moveIntent)
            }
        }
    }
}