package com.challenge.core.data.responses

import com.google.gson.annotations.SerializedName

data class TicketingResponse(
    @SerializedName("allInclusivePricing") val allInclusivePricing: AllInclusivePricingResponse? = null,
    @SerializedName("safeTix") val safeTix: SafeTixResponse? = null
)