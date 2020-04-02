package com.akshata.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentWeatherResponse {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("main")
    @Expose
    private CurrentWeatherMain main;

/**
 *  if we have a List of objects in our API
 *     private List<Weather> weatherList = null;
  */

    public String getCityName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public CurrentWeatherMain getMain() {
        return main;
    }

    public void setMain(CurrentWeatherMain main) {
        this.main = main;
    }
}
