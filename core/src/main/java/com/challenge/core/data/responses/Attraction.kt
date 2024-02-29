package com.challenge.core.data.responses

data class Attraction(
    val _links: LinksResponse? = null,
    val aliases: List<String>? = null,
    val classifications: List<Classification>? = null,
    val externalLinks: ExternalLinksResponse? = null,
    val id: String? = null,
    val images: List<ImagesResponse>? = null,
    val href: String? = null,
    val locale: String? = null,
    val name: String? = null,
    val test: Boolean? = null,
    val type: String? = null,
    val upcomingEvents: UpcomingEventsResponse? = null,
    val url: String? = null
)