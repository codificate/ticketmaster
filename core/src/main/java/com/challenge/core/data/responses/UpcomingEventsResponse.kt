package com.challenge.core.data.responses

import com.google.gson.annotations.SerializedName

data class UpcomingEventsResponse(
    @SerializedName("_filtered") val _filtered: Int? = 0,
    @SerializedName("_total") val _total: Int? = 0,
    @SerializedName("ticketmaster") val ticketmaster: Int? = 0,
    @SerializedName("tmr") val tmr: Int? = 0
)