package com.hninor.pruebamercadolibre.repository.entities

data class Result(
    val title: String? = null,
    val thumbnail: String? = null,
    val price: Long? = null,
    val currency_id: String? = null,
    val seller: Seller? = null,
    val address: Address? = null,
    val attributes: List<Attributes> = listOf()
)


