package com.challenge.core.data.repository

import com.challenge.core.data.service.TicketMasterApiService
import com.challenge.core.data.responses.TMResponse
import com.challenge.core.data.common.ApiState
import com.challenge.core.domain.repository.TicketMasterApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class TicketMasterApiRepositoryImpl(private val apiService: TicketMasterApiService) :
    TicketMasterApiRepository {
    override suspend fun fetchEvents(name: String): Flow<ApiState<TMResponse>> = flow {
        val eventName = name.ifEmpty { null }
        val eventsSize : Int? = if (name.isEmpty()) 10 else null
        val responseFlow = flowOf(apiService.searchEvents(keyword = eventName, size = eventsSize))
        responseFlow.collect { response ->
            val state = if (response.isSuccessful) {
                ApiState.Success(response.body()!!)
            } else {
                ApiState.Error(response.message())
            }
            emit(state)
        }
    }
}