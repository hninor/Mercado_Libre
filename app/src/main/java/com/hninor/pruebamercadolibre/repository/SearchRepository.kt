package com.hninor.pruebamercadolibre.repository

import com.hninor.pruebamercadolibre.repository.entities.Response

class SearchRepository {

    suspend fun fetchResults(query: String): Response {
        return reqApi.search(query)
    }
}
