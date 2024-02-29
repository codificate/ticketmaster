package com.challenge.core.data.responses

import com.google.gson.annotations.SerializedName

data class VenueResponse(
    @SerializedName("_links") val _links: LinksResponse? = null,
    @SerializedName("accessibleSeatingDetail") val accessibleSeatingDetail: String ? = null,
    @SerializedName("ada") val ada: AdaResponse? = null,
    @SerializedName("address") val address: AddressResponse? = null,
    @SerializedName("boxOfficeInfo") val boxOfficeInfo: BoxOfficeInfoResponse? = null,
    @SerializedName("city") val city: CityResponse? = null,
    @SerializedName("country") val country: CountryResponse? = null,
    @SerializedName("dmas") val dmas: List<DmaResponse> ? = null,
    @SerializedName("generalInfo") val generalInfo: GeneralInfoResponse? = null,
    @SerializedName("id") val id: String ? = null,
    @SerializedName("images") val images: List<ImagesResponse> ? = null,
    @SerializedName("locale") val locale: String ? = null,
    @SerializedName("location") val location: LocationResponse? = null,
    @SerializedName("markets") val markets: List<MarketResponse> ? = null,
    @SerializedName("name") val name: String ? = null,
    @SerializedName("parkingDetail") val parkingDetail: String ? = null,
    @SerializedName("postalCode") val postalCode: String ? = null,
    @SerializedName("state") val state: StateResponse? = null,
    @SerializedName("test") val test: Boolean ? = null,
    @SerializedName("timezone") val timezone: String ? = null,
    @SerializedName("type") val type: String ? = null,
    @SerializedName("upcomingEvents") val upcomingEvents: UpcomingEventsResponse? = null,
    @SerializedName("url") val url: String ? = null,
    @SerializedName("href") val href: String ? = null
)