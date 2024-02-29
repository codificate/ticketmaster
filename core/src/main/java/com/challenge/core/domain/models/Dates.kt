package com.challenge.core.domain.models

data class Dates(
    val spanMultipleDays: Boolean = false,
    val start: Start = Start(),
    val status: Status = Status(),
    val timezone: String = ""
)