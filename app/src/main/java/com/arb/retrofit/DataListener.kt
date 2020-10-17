package com.arb.retrofit

interface DataListener<T> {

    fun onSuccess(users: T)

    fun onError(error: Throwable)

}