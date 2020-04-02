package com.akshata.weather.api;

import com.akshata.weather.model.CurrentWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

//api key "ebfcac32bda131ed5a160f2757938396"

public interface WeatherApi {
@GET("data/2.5/weather")
//@GET("data/2.5/weather?q={city name}&appid={your api key}")
Call<CurrentWeatherResponse> getWeather(@Query("q") String cityName,
                                        @Query("appid") String apiKey);
}


