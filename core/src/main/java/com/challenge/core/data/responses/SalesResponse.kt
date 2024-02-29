package com.challenge.core.data.responses

data class SalesResponse(
    val presales: List<PresaleResponse> ? = null,
    val public: PublicResponse? = null
)