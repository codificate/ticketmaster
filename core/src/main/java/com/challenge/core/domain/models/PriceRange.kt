package com.challenge.core.domain.models

data class PriceRange(
    val currency: String,
    val max: Int,
    val min: Int,
    val type: String
)