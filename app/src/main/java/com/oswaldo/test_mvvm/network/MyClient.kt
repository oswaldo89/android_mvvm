package com.oswaldo.test_mvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyClient private constructor() {
    private val retrofit: Retrofit
    val myApi: MyApi
        get() = retrofit.create(MyApi::class.java)

    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    companion object {
        private val BASE_URL = "https://www.refugerestrooms.org/api/v1/"
        private var myClient: MyClient? = null
        val instance: MyClient
            @Synchronized get() {
                if (myClient == null) {
                    myClient = MyClient()
                }
                return myClient!!
            }
    }
}