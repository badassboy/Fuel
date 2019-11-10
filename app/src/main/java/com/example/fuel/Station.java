package com.example.fuel;

import com.google.gson.annotations.SerializedName;

public class Station {

//    @SerializedName("title")
    private String title;


    public Station(String title) {

        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }




}
