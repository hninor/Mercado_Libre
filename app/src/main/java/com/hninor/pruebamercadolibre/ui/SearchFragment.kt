package com.hninor.pruebamercadolibre.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hninor.pruebamercadolibre.databinding.FragmentSearchBinding
import com.hninor.pruebamercadolibre.repository.SearchRepository
import com.hninor.pruebamercadolibre.ui.adapter.SearchAdapter

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }


    private lateinit var viewModel: SearchViewModel

    private lateinit var binding: FragmentSearchBinding
    private val adapter = SearchAdapter {
        viewModel.showDetail(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        val viewModelFactory =
            SearchViewModelFactory(
                SearchRepository()
            )
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[SearchViewModel::class.java]
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    viewModel.search(query)
                    return true
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //throw Exception("Prueba Henry")
                return false
            }

        })
        setupRecyclerView()
        subscribe()
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())


        binding.recyclerView.adapter = this.adapter

        binding.swipeRefreshLayout.isRefreshing = false
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.refresh()
        }


    }


    private fun subscribe() {


        viewModel.result.observe(this) {
            binding.swipeRefreshLayout.isRefreshing = false
            adapter.results = it.toMutableList()
        }

        viewModel.navigateDetail.observe(this) {
            if (it) {
                (activity as SearchActivity).replaceFragment(
                    DetailFragment.newInstance(),
                    "FragmentC"
                )
                viewModel.navigateDetail.value = false
            }
        }
    }


}