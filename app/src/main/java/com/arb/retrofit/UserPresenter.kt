package com.arb.retrofit

import com.arb.retrofit.dataClass.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserPresenter(private val mListerer: DataListener<Users>) {

    private val api = ApiServices()


    fun getUserData(id:String){

        api
            .getApi()
            .getUser(id)
            .enqueue(object :Callback<Users>{
                override fun onResponse(call: Call<Users>, response: Response<Users>) {

                    val data = response.body()
                    if (data != null)
                        mListerer.onSuccess(data)

                }

                override fun onFailure(call: Call<Users>, t: Throwable) {
                    mListerer.onError(t)
                }
            })

    }

}