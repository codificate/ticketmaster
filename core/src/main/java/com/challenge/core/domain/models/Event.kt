package com.challenge.core.domain.models

data class Event(
    val dates: Dates,
    val id: String,
    val images: List<Images>,
    val locale: String,
    val name: String,
    val venues: List<Venue>,
    val type: String,
    val url: String
)