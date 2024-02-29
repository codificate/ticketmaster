package com.challenge.core.data.service

import com.challenge.core.BuildConfig
import com.challenge.core.data.responses.TMResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TicketMasterApiService {
    @GET("events")
    suspend fun searchEvents(
        @Query("keyword") keyword: String?,
        @Query("size") size: Int? = null,
        @Query("apikey") apiKey: String = BuildConfig.API_KEY
    ): Response<TMResponse>
}