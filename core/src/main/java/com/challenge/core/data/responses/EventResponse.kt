package com.challenge.core.data.responses

import com.google.gson.annotations.SerializedName

data class EventResponse(
    @SerializedName("_embedded") val embedded: EmbeddedResponse? = null,
    @SerializedName("_links") val links: LinksResponse? = null,
    @SerializedName("accessibility") val accessibility: AccessibilityResponse? = null,
    @SerializedName("ageRestrictions") val ageRestrictions: AgeRestrictions? = null,
    @SerializedName("classifications") val classifications: List<Classification>? = null,
    @SerializedName("dates") val dates: DatesResponse? = null,
    @SerializedName("id") val id: String? = null,
    @SerializedName("images") val images: List<ImagesResponse>? = null,
    @SerializedName("locale") val locale: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("pleaseNote") val pleaseNote: String? = null,
    @SerializedName("priceRanges") val priceRanges: List<PriceRangeResponse>? = null,
    @SerializedName("promoter") val promoter: PromoterResponse? = null,
    @SerializedName("promoters") val promoters: List<PromoterResponse>? = null,
    @SerializedName("sales") val sales: SalesResponse? = null,
    @SerializedName("seatmap") val seatmap: SeatmapResponse? = null,
    @SerializedName("test") val test: Boolean? = null,
    @SerializedName("ticketLimit") val ticketLimit: TicketLimitResponse? = null,
    @SerializedName("ticketing") val ticketing: TicketingResponse? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("url") val url: String? = null
)