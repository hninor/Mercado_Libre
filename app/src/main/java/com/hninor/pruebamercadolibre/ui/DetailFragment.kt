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
import com.hninor.pruebamercadolibre.MercadoLibreApplication
import com.hninor.pruebamercadolibre.R
import com.hninor.pruebamercadolibre.databinding.FragmentDetailBinding
import com.hninor.pruebamercadolibre.databinding.FragmentSearchBinding
import com.hninor.pruebamercadolibre.repository.SearchRepository
import com.hninor.pruebamercadolibre.ui.adapter.SearchAdapter

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }


    private lateinit var viewModel: SearchViewModel

    private lateinit var binding: FragmentDetailBinding
    private var imageLoader = MercadoLibreApplication.imageLoader

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val viewModelFactory =
            SearchViewModelFactory(
                SearchRepository()
            )
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[SearchViewModel::class.java]
        imageLoader.displayImage(viewModel.resultForDetail.thumbnail, binding.imageView)
        binding.tvTitle.text = viewModel.resultForDetail.title
        binding.tvPrice.text = viewModel.resultForDetail.price.toString()
        return binding.root
    }




    private fun subscribe() {


    }





}