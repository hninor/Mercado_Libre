package com.hninor.pruebamercadolibre.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.hninor.pruebamercadolibre.MercadoLibreApplication
import com.hninor.pruebamercadolibre.databinding.LayoutSearchItemBinding
import com.hninor.pruebamercadolibre.repository.entities.Result

class SearchViewHolder(private val binding: LayoutSearchItemBinding) :
    RecyclerView.ViewHolder(binding.root) {


    private var imageLoader = MercadoLibreApplication.imageLoader
    fun bind(result: Result) {
        binding.tvTitle.text = result.title
        binding.tvPrice.text = result.price.toString()
        imageLoader.displayImage(result.thumbnail, binding.imageView)
    }



}