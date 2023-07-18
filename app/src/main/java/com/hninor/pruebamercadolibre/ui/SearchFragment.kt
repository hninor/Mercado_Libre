package com.hninor.pruebamercadolibre.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hninor.pruebamercadolibre.R
import com.hninor.pruebamercadolibre.repository.SearchRepository

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }


    private val viewModel: SearchViewModel by viewModels {
        val repository = SearchRepository()
        SearchViewModelFactory(repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_search, container, false)
        viewModel.search("Motorola")
        return root
    }



}