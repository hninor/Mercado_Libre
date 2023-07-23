package com.hninor.pruebamercadolibre.ui

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hninor.pruebamercadolibre.R
import com.hninor.pruebamercadolibre.databinding.FragmentSearchBinding
import com.hninor.pruebamercadolibre.repository.SearchRepository
import com.hninor.pruebamercadolibre.ui.adapter.SearchAdapter

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }


    private val viewModel: SearchViewModel by viewModels {
        val repository = SearchRepository()
        SearchViewModelFactory(repository)
    }

    private lateinit var binding: FragmentSearchBinding
    private val adapter = SearchAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        viewModel.search("Motorola")
        setupRecyclerView()
        subscribe()
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())


        binding.recyclerView.adapter = this.adapter

        binding.swipeRefreshLayout.isRefreshing = true
        binding.swipeRefreshLayout.setOnRefreshListener {
            //viewModel.refreshTweets()
        }


    }


    private fun subscribe() {


        viewModel.result.observe(this) {
            binding.swipeRefreshLayout.isRefreshing = false
            adapter.results = it.toMutableList()
        }
    }



}