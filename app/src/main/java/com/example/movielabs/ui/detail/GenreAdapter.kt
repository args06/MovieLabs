package com.example.movielabs.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielabs.data.model.GenreListItem
import com.example.movielabs.databinding.GenreItemBinding

class GenreAdapter(private val genreList: List<GenreListItem>) : RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    class ViewHolder(var binding: GenreItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GenreItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = genreList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val genreItem = genreList[position]
        holder.binding.apply {
            tvGenre.text = genreItem.value
        }
    }
}