package com.challenge.core.domain.models

data class Images(
    val fallback: Boolean = false,
    val height: Int = 0,
    val ratio: String = "",
    val url: String = "",
    val width: Int = 0
)