package com.example.fuel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetStations {

    @GET("/photos")
    Call<List<Station>> getAllPhotos();
}
