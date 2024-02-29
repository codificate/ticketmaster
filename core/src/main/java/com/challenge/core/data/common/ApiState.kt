package com.challenge.core.data.common

sealed class ApiState<T> {
    data class Success<T>(val data: T): ApiState<T>()
    data class Error<T>(val message: String): ApiState<T>()
}