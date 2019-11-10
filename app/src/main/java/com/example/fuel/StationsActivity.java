package com.example.fuel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StationsActivity extends AppCompatActivity {

    private CustomAdapter customAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations);

//        Toolbar toolbar = (Toolbar)findViewById(R.id.station_toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitle("Staions Nearby");

        GetStations stations = RetroClient.getRetroClientInstance().create(GetStations.class);
        Call<List<Station>> call = stations.getAllPhotos();
        call.enqueue(new Callback<List<Station>>() {
            @Override
            public void onResponse(Call<List<Station>> call, Response<List<Station>> response) {
                generateStationList(response.body());
            }

            @Override
            public void onFailure(Call<List<Station>> call, Throwable t) {

            }
        });
    }

    private void generateStationList(List<Station> list){

        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        customAdapter = new CustomAdapter(list,this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customAdapter);



    }
}
