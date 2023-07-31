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
import com.hninor.pruebamercadolibre.repository.entities.Attributes
import com.hninor.pruebamercadolibre.ui.adapter.SearchAdapter
import java.lang.StringBuilder
import java.text.DecimalFormat

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
        val result = viewModel.resultForDetail
        binding.tvTitle.text = result.title
        binding.tvPrice.text = renderPrice(result.price)
        binding.tvCurrency.text = result.currency_id

        binding.tvVendedor.text = result.seller?.nickname

        binding.tvDireccion.text = result.address?.city_name
        binding.tvDireccion2.text = result.address?.state_name
        binding.tvAtributos.text = renderAttributes(result.attributes)
        return binding.root
    }

    fun renderAttributes(attributes: List<Attributes>): String {
        val stringBuilder = StringBuilder()
        for (attribute in attributes) {
            stringBuilder.append("${attribute.name}: ${attribute.value_name}")
            stringBuilder.append("\n")
        }
        return stringBuilder.toString()
    }

    fun renderPrice(price: Long?): String {
        var response = "$ 0"
        if (price != null) {
            val format = DecimalFormat("#,###")
            response = "$ " + format.format(price)
        }

        return response
    }




    private fun subscribe() {


    }





}