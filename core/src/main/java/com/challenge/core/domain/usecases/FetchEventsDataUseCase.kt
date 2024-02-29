package com.challenge.core.domain.usecases

import com.challenge.core.data.common.ApiState
import com.challenge.core.domain.mappers.EventsMapper
import com.challenge.core.domain.models.Event
import com.challenge.core.domain.repository.TicketMasterApiRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class FetchEventsDataUseCase(
    private val mapper: EventsMapper,
    private val repository: TicketMasterApiRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend operator fun invoke(eventName: String): Flow<List<Event>> {
        return repository.fetchEvents(eventName)
            .map { response ->
                when (response) {
                    is ApiState.Error -> emptyList()
                    is ApiState.Success -> response.data.embedded?.events?.map { eventResponse ->
                        mapper.toEvent(eventResponse)
                    }?: emptyList()
                }
            }
            .flowOn(context = dispatcher)
    }
}