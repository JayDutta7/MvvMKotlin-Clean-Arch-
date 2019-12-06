package com.jdhome.mvvmkotlin.networking.sealedClass

sealed class Action {
    object Load : Action()
    object SwipeRefresh : Action()
    object Retry : Action()
}