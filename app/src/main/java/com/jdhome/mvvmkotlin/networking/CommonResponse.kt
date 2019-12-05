package com.jdhome.mvvmkotlin.networking

sealed class CommonResponse<out T: Any> {
    data class Success<out T : Any>(val data: T) : CommonResponse<T>()
    data class Error(val exception: Throwable) : CommonResponse<Nothing>()
}