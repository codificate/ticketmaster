package com.challenge.core.data.responses

data class PriceRangeResponse(
    val currency: String? = null,
    val max: Double? = null,
    val min: Double? = null,
    val type: String? = null
)