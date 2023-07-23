package com.hninor.pruebamercadolibre.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hninor.pruebamercadolibre.repository.SearchRepository
import kotlinx.coroutines.launch


private const val PAGE_RESULT_COUNT = 100
class SearchViewModel(val repository: SearchRepository) : ViewModel() {

    val result: MutableLiveData<List<com.hninor.pruebamercadolibre.repository.entities.Result>> by lazy {
        MutableLiveData<List<com.hninor.pruebamercadolibre.repository.entities.Result>>().also { }
    }

    private var allResults: List<com.hninor.pruebamercadolibre.repository.entities.Result>? = null

    fun search(query: String) {

        viewModelScope.launch {
            val response = repository.fetchResults(query)
            allResults = response.results

            if ((allResults?.size ?: 0) > PAGE_RESULT_COUNT) {
                result.value = allResults?.subList(0, PAGE_RESULT_COUNT)
            } else {
                result.value = allResults
            }
        }
    }
}