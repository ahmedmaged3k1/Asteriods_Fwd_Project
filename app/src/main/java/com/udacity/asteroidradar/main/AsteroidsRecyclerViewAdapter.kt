package com.udacity.asteroidradar.main

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.StartDate
import com.udacity.asteroidradar.databinding.AsteroidItemBinding
import com.udacity.asteroidradar.test.AsteroidPracable


val diffCallback = object : DiffUtil.ItemCallback<StartDate>() {
    override fun areItemsTheSame(oldItem: StartDate, newItem: StartDate): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: StartDate, newItem: StartDate): Boolean {
        return false


    }
}

@Suppress("DEPRECATION")
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

        init {
            binding.constraintLayout.setOnClickListener {
                Log.d("TAG", "message ${getItem(position).toString()} ")
                Log.d(TAG, "message ${getItem(position).relative_velocity}: ")
                val asteroid = AsteroidPracable(
                    getItem(position).close_approach_data[0].close_approach_date_full,
                    getItem(position).absolute_magnitude_h.toString(),
                    getItem(position).close_approach_data[0].relative_velocity.kilometers_per_hour.toString(),
                    getItem(position).estimated_diameter.kilometers.estimated_diameter_max.toString(),
                    getItem(position).close_approach_data[0].miss_distance.kilometers.toString(),
                    getItem(position).is_potentially_hazardous_asteroid
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

