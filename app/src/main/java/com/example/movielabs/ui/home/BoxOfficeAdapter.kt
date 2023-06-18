package com.example.movielabs.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielabs.data.model.BoxOfficeItem
import com.example.movielabs.databinding.BoxOfficeItemBinding
import com.example.movielabs.helper.Constant
import com.example.movielabs.helper.Utils.getWeeks
import com.example.movielabs.ui.detail.DetailActivity

class BoxOfficeAdapter(private val listMovie: List<BoxOfficeItem>) : RecyclerView.Adapter<BoxOfficeAdapter.ViewHolder>() {

    class ViewHolder(var binding: BoxOfficeItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BoxOfficeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieItem = listMovie[position]
        holder.binding.apply {
            Glide.with(holder.itemView.context).load(movieItem.image).into(ivBoxOfficeImage)
            tvNumber.text = movieItem.rank
            tvBoxOfficeTitle.text = movieItem.title
            tvWeeks.text = getWeeks(movieItem.weeks)
            tvGross.text = movieItem.gross
            clBoxOfficeItem.setOnClickListener() {
                val moveIntent = Intent(it.context, DetailActivity::class.java)
                moveIntent.putExtra(Constant.EXTRA_MOVIE_ID, movieItem.id)
                moveIntent.putExtra(Constant.EXTRA_MOVIE_TITLE, movieItem.title)
                it.context.startActivity(moveIntent)
            }
        }
    }
}