package com.challenge.core.data.responses

import com.google.gson.annotations.SerializedName

data class LinksResponse(
    @SerializedName("first") val first: FirstResponse? = null,
    @SerializedName("last") val last: LastResponse? = null,
    @SerializedName("next") val next: NextResponse? = null,
    @SerializedName("self") val self: SelfResponse? = null
)