package com.challenge.core.data.responses

data class PublicResponse(
    val endDateTime: String ? = null,
    val startDateTime: String ? = null,
    val startTBA: Boolean = false,
    val startTBD: Boolean = false
)