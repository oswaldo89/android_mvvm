package com.oswaldo.test_mvvm.network

import com.oswaldo.test_mvvm.data.Restroom
import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface MyApi {
    @GET("restrooms.json")
    fun getRestroomsData(): Call<ArrayList<Restroom>>
}