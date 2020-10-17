package com.arb.retrofit

import com.arb.retrofit.dataClass.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersPresenter(private val mListerer: DataListener<List<Users>>) {

    private val api = ApiServices()

    fun getUsersData(){

        api
            .getApi()
            .getUsers()
            .enqueue(object :Callback<List<Users>>{
                override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {

                    val data = response.body()
                    if (data != null)
                        mListerer.onSuccess(data)

                }

                override fun onFailure(call: Call<List<Users>>, t: Throwable) {

                    mListerer.onError(t)

                }
            })

    }

}