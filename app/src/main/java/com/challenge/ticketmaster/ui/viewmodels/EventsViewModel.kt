package com.challenge.ticketmaster.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.challenge.core.domain.usecases.FetchEventsDataUseCase
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
                    mutableState.emit(UIState.Info(values))
                }
        }
    }

    fun searchEvent(eventName: String) {
        viewModelScope.launch {
            mutableState.emit(UIState.Loading)
            fetchEventsDataUseCase(eventName)
                .collectLatest { values ->
                    mutableState.emit(UIState.Info(values))
                }
        }
    }
}