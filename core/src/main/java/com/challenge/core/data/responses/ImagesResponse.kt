package com.challenge.core.data.responses

data class ImagesResponse(
    val fallback: Boolean = false,
    val height: Int = 0,
    val ratio: String? = null,
    val url: String? = null,
    val width: Int = 0
)