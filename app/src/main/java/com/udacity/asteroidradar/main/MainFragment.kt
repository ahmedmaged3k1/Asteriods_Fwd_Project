package com.udacity.asteroidradar.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val asteroidsRecyclerViewAdapter = AsteroidsRecyclerViewAdapter()
    private val viewModel: MainViewModel by viewModels()
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel
    CoroutineScope(Dispatchers.IO).launch{
        viewModel.getImage()
    }
        setHasOptionsMenu(true)

        initializeRecyclerView()
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }

    private fun initializeRecyclerView() {
        binding.asteroidRecycler.adapter = asteroidsRecyclerViewAdapter
        viewModel.getAsteroids("2015-09-05", "2015-09-6")
        viewModel.asteroidsLive.observe(viewLifecycleOwner) {
           // asteroidsRecyclerViewAdapter.submitList(viewModel.asteroidsLive.value)


        }


    }
}
