package com.challenge.core.data.responses

import com.google.gson.annotations.SerializedName

data class DatesResponse(
    @SerializedName("spanMultipleDays") val spanMultipleDays: Boolean = false,
    @SerializedName("start") val start: StartResponse? = null,
    @SerializedName("status") val status: StatusResponse? = null,
    @SerializedName("timezone") val timezone: String ? = null
)