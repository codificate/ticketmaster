package com.challenge.core.data.responses

import com.google.gson.annotations.SerializedName

data class EventResponse(
    @SerializedName("_embedded") val embedded: EmbeddedResponse?,
    @SerializedName("_links") val links: LinksResponse?,
    @SerializedName("accessibility") val accessibility: AccessibilityResponse?,
    @SerializedName("ageRestrictions") val ageRestrictions: AgeRestrictions?,
    @SerializedName("classifications") val classifications: List<Classification>?,
    @SerializedName("dates") val dates: DatesResponse?,
    @SerializedName("id") val id: String?,
    @SerializedName("images") val images: List<ImagesResponse>?,
    @SerializedName("locale") val locale: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("pleaseNote") val pleaseNote: String?,
    @SerializedName("priceRanges") val priceRanges: List<PriceRangeResponse>?,
    @SerializedName("promoter") val promoter: PromoterResponse?,
    @SerializedName("promoters") val promoters: List<PromoterResponse>?,
    @SerializedName("sales") val sales: SalesResponse?,
    @SerializedName("seatmap") val seatmap: SeatmapResponse?,
    @SerializedName("test") val test: Boolean?,
    @SerializedName("ticketLimit") val ticketLimit: TicketLimitResponse?,
    @SerializedName("ticketing") val ticketing: TicketingResponse?,
    @SerializedName("type") val type: String?,
    @SerializedName("url") val url: String?
)