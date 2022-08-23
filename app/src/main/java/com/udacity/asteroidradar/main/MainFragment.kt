package com.udacity.asteroidradar.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getImage()
        }
        setHasOptionsMenu(true)
        binding.asteroidRecycler.adapter = asteroidsRecyclerViewAdapter

        initializeRecyclerView()
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.show_buy_menu -> initializeRecyclerView()
            R.id.show_rent_menu -> saved()
            R.id.show_all_menu -> week()

        }
        return true
    }

    private fun initializeRecyclerView() {
        viewModel.getAsteroids("2018-5-6", "2018-5-5")
        viewModel.asteroidsLive.observe(viewLifecycleOwner) {
            asteroidsRecyclerViewAdapter.submitList(viewModel.asteroidsLive.value)


        }


    }
    private fun saved() {
        viewModel.getSaved()
        viewModel.asteroidsLive.observe(viewLifecycleOwner) {
            asteroidsRecyclerViewAdapter.submitList(viewModel.asteroidsLive.value)


        }


    }
    private fun week() {
        viewModel.getWeek("2016-09-05", "2016-09-06")
        viewModel.asteroidsLive.observe(viewLifecycleOwner) {
            asteroidsRecyclerViewAdapter.submitList(viewModel.asteroidsLive.value)


        }


    }
}
