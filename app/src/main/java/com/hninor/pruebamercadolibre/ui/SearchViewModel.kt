package com.hninor.pruebamercadolibre.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hninor.pruebamercadolibre.repository.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel(val repository: SearchRepository) : ViewModel() {


    fun search(query: String) {

        viewModelScope.launch {
            val result = repository.fetchResults(query)
        }
    }
}