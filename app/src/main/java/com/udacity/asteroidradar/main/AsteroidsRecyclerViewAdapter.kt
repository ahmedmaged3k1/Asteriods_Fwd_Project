package com.udacity.asteroidradar.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.udacity.asteroidradar.StartDate
import com.udacity.asteroidradar.databinding.AsteroidItemBinding


val diffCallback = object : DiffUtil.ItemCallback<StartDate>() {
    override fun areItemsTheSame(oldItem: StartDate, newItem: StartDate): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: StartDate, newItem: StartDate): Boolean {
        return oldItem.id == newItem.id


    }
}

class AsteroidsRecyclerViewAdapter :
    ListAdapter<StartDate, AsteroidsRecyclerViewAdapter.AsteroidsViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidsViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(holder: AsteroidsViewHolder, position: Int) {
        holder.bind(getItem(position))


    }

    inner class AsteroidsViewHolder constructor(private val binding: AsteroidItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: StartDate?) {
            binding.asteroids = item
            binding.executePendingBindings()

        }


    }

    fun from(parent: ViewGroup): AsteroidsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AsteroidItemBinding.inflate(inflater, parent, false)
        return AsteroidsViewHolder(binding)
    }


}

