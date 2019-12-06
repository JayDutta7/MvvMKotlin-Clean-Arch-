package com.jdhome.mvvmkotlin.networking.sealedClass

sealed class CommonResponse<out T> {
    data class Success<out T>(val data: T) : CommonResponse<T>()
    data class Loading<out T>(val partialData: T? = null) : CommonResponse<T>()
    data class Failure<out T>(val throwable: Throwable? = null) : CommonResponse<T>()

    val extractData: T? get() = when (this) {
        is Success -> data
        is Loading -> partialData
        is Failure -> null
    }
}