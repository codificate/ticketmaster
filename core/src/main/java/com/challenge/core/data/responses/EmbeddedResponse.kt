package com.challenge.core.data.responses

import com.google.gson.annotations.SerializedName

data class EmbeddedResponse(
    @SerializedName("events") val events: List<EventResponse>?,
    @SerializedName("venues") val venues: List<VenueResponse>?
)