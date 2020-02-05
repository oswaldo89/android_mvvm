package com.oswaldo.test_mvvm.network.room;


import androidx.lifecycle.MutableLiveData;

import com.oswaldo.test_mvvm.data.Restroom;
import com.oswaldo.test_mvvm.network.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomsRepository {

    private static RoomsRepository roomsRepository;

    public static RoomsRepository getInstance() {
        if (roomsRepository == null) {
            roomsRepository = new RoomsRepository();
        }
        return roomsRepository;
    }

    private RoomsApi RoomsApi;

    private RoomsRepository() {
        RoomsApi = RetrofitService.cteateService(RoomsApi.class);
    }

    public MutableLiveData<ArrayList<Restroom>> getData() {
        final MutableLiveData<ArrayList<Restroom>> newsData = new MutableLiveData<>();
        RoomsApi.getRestroomsData().enqueue(new Callback<ArrayList<Restroom>>() {
            @Override
            public void onResponse(Call<ArrayList<Restroom>> call,Response<ArrayList<Restroom>> response) {
                if (response.isSuccessful()) {
                    newsData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Restroom>> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
