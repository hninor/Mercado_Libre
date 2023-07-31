package com.hninor.pruebamercadolibre.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.hninor.pruebamercadolibre.MercadoLibreApplication
import com.hninor.pruebamercadolibre.databinding.LayoutSearchItemBinding
import com.hninor.pruebamercadolibre.repository.entities.Result
import java.text.DecimalFormat

class SearchViewHolder(private val binding: LayoutSearchItemBinding) :
    RecyclerView.ViewHolder(binding.root) {


    private var imageLoader = MercadoLibreApplication.imageLoader
    fun bind(result: Result, clickListener: (Result) -> Unit) {
        binding.tvTitle.text = result.title
        binding.tvPrice.text = renderPrice(result.price)
        binding.tvCurrency.text = result.currency_id
        imageLoader.displayImage(result.thumbnail, binding.imageView)
        binding.root.setOnClickListener { clickListener(result) }
    }

    fun renderPrice(price: Long?): String {
        var response = "$ 0"
        if (price != null) {
            val format = DecimalFormat("#,###")
            response = "$ " + format.format(price)
        }

        return response
    }


}