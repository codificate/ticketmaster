package com.challenge.core.data.responses

import com.google.gson.annotations.SerializedName

data class StartResponse(
    @SerializedName("dateTBA") val dateTBA: Boolean = false,
    @SerializedName("dateTBD") val dateTBD: Boolean = false,
    @SerializedName("dateTime") val dateTime: String ? = null,
    @SerializedName("localDate") val localDate: String ? = null,
    @SerializedName("localTime") val localTime: String ? = null,
    @SerializedName("noSpecificTime") val noSpecificTime: Boolean = false,
    @SerializedName("timeTBA") val timeTBA: Boolean = false
)