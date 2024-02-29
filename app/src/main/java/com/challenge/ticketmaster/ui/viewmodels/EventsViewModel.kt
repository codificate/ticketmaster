package com.challenge.ticketmaster.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.core.domain.models.Event
import com.challenge.core.domain.usecases.FetchEventsDataUseCase
import com.challenge.ticketmaster.R
import com.challenge.ticketmaster.ui.data.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val fetchEventsDataUseCase: FetchEventsDataUseCase
): ViewModel() {
    private val mutableState = MutableStateFlow<UIState>(UIState.Init)

    val state: StateFlow<UIState> = mutableState
    init {
        viewModelScope.launch {
            mutableState.emit(UIState.Loading)
            fetchEventsDataUseCase("")
                .collectLatest { values ->
                    emitResults(values)
                }
        }
    }

    fun searchEvent(eventName: String) {
        viewModelScope.launch {
            mutableState.emit(UIState.Loading)
            fetchEventsDataUseCase(eventName)
                .collectLatest { values ->
                    emitResults(values)
                }
        }
    }

    private suspend fun emitResults(values: List<Event>) {
        if (values.isEmpty()) {
            mutableState.emit(UIState.Error(raw = R.string.event_search_not_found))
        } else {
            values.sortedBy { event ->
                event.dates.start.localDate
            }
            mutableState.emit(UIState.Info(values))
        }
    }
}