package com.challenge.core.data.responses

import com.google.gson.annotations.SerializedName

data class VenueResponse(
    @SerializedName("_links") val _links: LinksResponse?,
    @SerializedName("accessibleSeatingDetail") val accessibleSeatingDetail: String ?,
    @SerializedName("ada") val ada: AdaResponse?,
    @SerializedName("address") val address: AddressResponse?,
    @SerializedName("boxOfficeInfo") val boxOfficeInfo: BoxOfficeInfoResponse?,
    @SerializedName("city") val city: CityResponse?,
    @SerializedName("country") val country: CountryResponse?,
    @SerializedName("dmas") val dmas: List<DmaResponse> ?,
    @SerializedName("generalInfo") val generalInfo: GeneralInfoResponse?,
    @SerializedName("id") val id: String ?,
    @SerializedName("images") val images: List<ImagesResponse> ?,
    @SerializedName("locale") val locale: String ?,
    @SerializedName("location") val location: LocationResponse?,
    @SerializedName("markets") val markets: List<MarketResponse> ?,
    @SerializedName("name") val name: String ?,
    @SerializedName("parkingDetail") val parkingDetail: String ?,
    @SerializedName("postalCode") val postalCode: String ?,
    @SerializedName("state") val state: StateResponse?,
    @SerializedName("test") val test: Boolean ?,
    @SerializedName("timezone") val timezone: String ?,
    @SerializedName("type") val type: String ?,
    @SerializedName("upcomingEvents") val upcomingEvents: UpcomingEventsResponse?,
    @SerializedName("url") val url: String ?,
    @SerializedName("href") val href: String ?
)