package com.challenge.core.data.responses

import com.google.gson.annotations.SerializedName

data class TMResponse(
    @SerializedName("_embedded") val embedded: EmbeddedResponse,
    @SerializedName("_links") val links: LinksResponse,
    @SerializedName("page") val page: PageResponse
)