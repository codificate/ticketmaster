package com.challenge.core.domain.models

data class Event(
    //val accessibility: Accessibility,
    //val ageRestrictions: AgeRestrictions,
    //val classifications: List<Classification>,
    val dates: Dates,
    val id: String,
    val images: List<Images>,
    val locale: String,
    val name: String,
    val venues: List<Venue>,
    //val pleaseNote: String,
    //val priceRanges: List<PriceRange>,
    //val promoter: Promoter,
    //val promoters: List<Promoter>,
    //val sales: Sales,
    //val seatmap: Seatmap,
    //val test: Boolean,
    //val ticketLimit: TicketLimit,
    //val ticketing: Ticketing,
    val type: String,
    val url: String
)