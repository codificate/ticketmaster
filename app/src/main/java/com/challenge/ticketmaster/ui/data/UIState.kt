package com.challenge.ticketmaster.ui.data

import androidx.annotation.StringRes
import com.challenge.core.domain.models.Event

sealed class UIState {
    object Init : UIState()
    object Loading : UIState()
    data class Info(val values: List<Event>) : UIState()
    data class Error(val message: String? = null, @StringRes val raw: Int? = null) : UIState()
}