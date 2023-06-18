package com.example.movielabs.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielabs.data.model.ActorListItem
import com.example.movielabs.databinding.CastItemBinding

class CastAdapter(private val castList: List<ActorListItem>) : RecyclerView.Adapter<CastAdapter.ViewHolder>() {

    class ViewHolder(var binding: CastItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CastItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = castList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val castItem = castList[position]
        holder.binding.apply {
            Glide.with(holder.itemView.context).load(castItem.image).into(ivActorImage)
            tvActorName.text = castItem.name
            tvCharacterName.text = castItem.asCharacter
        }
    }
}