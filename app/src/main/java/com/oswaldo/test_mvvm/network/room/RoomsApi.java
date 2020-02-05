package com.oswaldo.test_mvvm.network.room;

import com.oswaldo.test_mvvm.data.Restroom;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RoomsApi {
    @GET("restrooms.json")
    Call<ArrayList<Restroom>> getRestroomsData();
}
