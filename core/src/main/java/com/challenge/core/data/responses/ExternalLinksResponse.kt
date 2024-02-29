package com.challenge.core.data.responses

data class ExternalLinksResponse(
    val facebook: List<FacebookResponse>? = null,
    val homepage: List<HomepageResponse>? = null,
    val instagram: List<InstagramResponse>? = null,
    val twitter: List<TwitterResponse>? = null,
    val wiki: List<WikiResponse>? = null
)