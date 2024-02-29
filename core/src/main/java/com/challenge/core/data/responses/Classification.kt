package com.challenge.core.data.responses

import com.google.gson.annotations.SerializedName

data class Classification(
    @SerializedName("family") val family: Boolean = false,
    @SerializedName("genre") val genre: GenreResponse? = null,
    @SerializedName("primary") val primary: Boolean = false,
    @SerializedName("segment") val segment: SegmentResponse? = null,
    @SerializedName("subGenre") val subGenre: SubGenreResponse? = null,
    @SerializedName("subType") val subType: SubTypeResponse? = null,
    @SerializedName("type") val type: TypeResponse? = null
)