package com.challenge.core.domain.models

data class Venue(
    val city: City,
    val country: Country,
    val id: String,
    val name: String,
    val state: State
    /*
    val accessibleSeatingDetail: String,
    val ada: Ada,
    val address: Address,
    val boxOfficeInfo: BoxOfficeInfo,
    val city: City,
    val country: Country,
    val dmas: List<Dma>,
    val generalInfo: GeneralInfo,
    val id: String,
    val images: List<Images>,
    val locale: String,
    val location: Location,
    val markets: List<Market>,
    val name: String,
    val parkingDetail: String,
    val postalCode: String,
    val state: State,
    val test: Boolean,
    val timezone: String,
    val type: String,
    val upcomingEvents: UpcomingEvents,
    val url: String
     */
)