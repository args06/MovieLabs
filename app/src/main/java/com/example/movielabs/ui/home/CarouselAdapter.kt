package com.example.movielabs.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielabs.R
import com.example.movielabs.data.model.MovieItem
import com.example.movielabs.databinding.CarouselItemBinding
import com.example.movielabs.helper.Constant
import com.example.movielabs.ui.detail.DetailActivity

class CarouselAdapter(private val listMovie: List<MovieItem>) :
    RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {

    class ViewHolder(val binding: CarouselItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieItem = listMovie[position]
        holder.binding.apply {
            Glide.with(rivMovieImageCarousel).load(movieItem.image).into(rivMovieImageCarousel)
            tvMovieNameCarousel.text = movieItem.title
            llCarouselItem.setOnClickListener() {
                val moveIntent = Intent(it.context, DetailActivity::class.java)
                moveIntent.putExtra(Constant.EXTRA_MOVIE_ID, movieItem.id)
                moveIntent.putExtra(Constant.EXTRA_MOVIE_TITLE, movieItem.title)
                it.context.startActivity(moveIntent)
            }
        }
    }
}