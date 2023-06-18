package com.example.movielabs.ui.search

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielabs.data.model.BoxOfficeItem
import com.example.movielabs.data.model.SearchItem
import com.example.movielabs.databinding.BoxOfficeItemBinding
import com.example.movielabs.databinding.SearchItemBinding
import com.example.movielabs.helper.Constant
import com.example.movielabs.helper.Utils
import com.example.movielabs.ui.detail.DetailActivity
import com.example.movielabs.ui.home.BoxOfficeAdapter

class SearchAdapter(private val searchList: List<SearchItem>) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    class ViewHolder(var binding: SearchItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = searchList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val searchItem = searchList[position]
        holder.binding.apply {
            Glide.with(holder.itemView.context).load(searchItem.image).into(ivSearchImage)
            tvSearchTitle.text = searchItem.title
            tvSearchYear.text = Utils.getYear(searchItem.description)
            tvSearchDesc.text = Utils.getDesc(searchItem.description)
            clSearchItem.setOnClickListener() {
                val moveIntent = Intent(it.context, DetailActivity::class.java)
                moveIntent.putExtra(Constant.EXTRA_MOVIE_ID, searchItem.id)
                moveIntent.putExtra(Constant.EXTRA_MOVIE_TITLE, searchItem.title)
                it.context.startActivity(moveIntent)
            }
        }
    }
}