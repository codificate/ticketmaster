package com.challenge.core.domain.repository

import com.challenge.core.data.responses.TMResponse
import com.challenge.core.data.common.ApiState
import kotlinx.coroutines.flow.Flow

interface TicketMasterApiRepository {
    suspend fun fetchEvents(name: String): Flow<ApiState<TMResponse>>
}