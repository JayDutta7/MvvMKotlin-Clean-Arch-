package com.jdhome.mvvmkotlin.networking

sealed class Res<out T: Any> {
    data class Success<out T : Any>(val data: T) : Res<T>()
    data class Error(val exception: Throwable) : Res<Nothing>()
}