package com.udacity.asteroidradar.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.databinding.AsteroidItemBinding
import com.udacity.asteroidradar.test.AsteroidPracable


val diffCallback = object : DiffUtil.ItemCallback<AsteroidPracable>() {
    override fun areItemsTheSame(oldItem: AsteroidPracable, newItem: AsteroidPracable): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: AsteroidPracable, newItem: AsteroidPracable): Boolean {
        return false


    }
}

@Suppress("DEPRECATION")
class AsteroidsRecyclerViewAdapter :
    ListAdapter<AsteroidPracable, AsteroidsRecyclerViewAdapter.AsteroidsViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidsViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(holder: AsteroidsViewHolder, position: Int) {
        holder.bind(getItem(position))


    }

    inner class AsteroidsViewHolder constructor(private val binding: AsteroidItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AsteroidPracable?) {
            binding.asteroids = item
            binding.executePendingBindings()

        }

        init {
            binding.constraintLayout.setOnClickListener {

                val asteroid = AsteroidPracable(
                    getItem(position).startDate,
                    endDate = "",
                    getItem(position).magnituide,
                    getItem(position).velocity,
                    getItem(position).diamter,
                    getItem(position).distance,
                    getItem(position).imageFlag,
                    getItem(position).name
                )
                val action = MainFragmentDirections.actionShowDetail(asteroid)

                binding.root.findNavController().navigate(action)

            }
        }
    }


    fun from(parent: ViewGroup): AsteroidsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AsteroidItemBinding.inflate(inflater, parent, false)
        return AsteroidsViewHolder(binding)
    }


}

