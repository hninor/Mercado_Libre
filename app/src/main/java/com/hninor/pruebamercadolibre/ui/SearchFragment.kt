package com.hninor.pruebamercadolibre.ui

import android.R.attr.name
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.hninor.pruebamercadolibre.databinding.FragmentSearchBinding
import com.hninor.pruebamercadolibre.repository.SearchRepository
import com.hninor.pruebamercadolibre.ui.adapter.SearchAdapter


class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }


    private lateinit var viewModel: SearchViewModel
    private lateinit var firebaseAnalytics: FirebaseAnalytics

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
        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory)[SearchViewModel::class.java]
        firebaseAnalytics = Firebase.analytics
        binding.searchView.isIconified = false
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    val bundle = Bundle()
                    bundle.putString("query", query)
                    firebaseAnalytics.logEvent("busqueda", bundle)
                    binding.swipeRefreshLayout.isRefreshing = true
                    viewModel.search(query)
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