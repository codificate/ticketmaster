package com.challenge.core.domain.models

data class Venue(
    val city: City,
    val country: Country,
    val id: String,
    val name: String,
    val state: State
)