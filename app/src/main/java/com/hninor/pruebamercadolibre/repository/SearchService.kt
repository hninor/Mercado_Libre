package com.hninor.pruebamercadolibre.repository

import com.hninor.pruebamercadolibre.repository.entities.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET("sites/MCO/search")
    suspend fun search(@Query("q") query: String): Response


}
