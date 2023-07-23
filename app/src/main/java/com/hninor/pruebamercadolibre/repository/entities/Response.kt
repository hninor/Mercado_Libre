package com.hninor.pruebamercadolibre.repository.entities

data class Response(
    var results: List<Result> = listOf(),
    var site_id: String? = null
)