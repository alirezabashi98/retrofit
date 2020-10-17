package com.arb.retrofit

import com.arb.retrofit.dataClass.Users
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class ApiServices {

    interface ApiService {

        @GET("users")
        fun getUsers(): Call<List<Users>>

        @GET("users/{id}")
        fun getUser(@Path("id") id :String): Call<Users>

    }

    fun getApi(): ApiService =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(ApiService::class.java)

}