package com.akshata.weather;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.akshata.weather.api.WeatherApi;
import com.akshata.weather.api.WeatherService;
import com.akshata.weather.model.CurrentWeatherResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Singleton class ... it has only one object.
 */
public class WeatherRepository {

    private static WeatherRepository weatherRepository;

    private static final String API_KEY = "e492ac1e255367762767d1d49fa78e0b";
    public static WeatherRepository getInstance(){
        if(weatherRepository == null){
            weatherRepository = new WeatherRepository();
        }
        return weatherRepository;
    }
    // Create instance of Api interface.
    private WeatherApi weatherApi;

    /**
     * Creating a constructor where intializing instance of Api interface
     */

    private WeatherRepository(){
        weatherApi = WeatherService.createService(WeatherApi.class);
    }

    public MutableLiveData<CurrentWeatherResponse> getCurrentWeather (String cityName){
        MutableLiveData<CurrentWeatherResponse> currentWeatherResponseMutableLiveData =  new MutableLiveData<>();
        weatherApi.getWeather(cityName, API_KEY).enqueue(new Callback<CurrentWeatherResponse>() {
            @Override
            public void onResponse(Call<CurrentWeatherResponse> call, Response<CurrentWeatherResponse> response) {
                if(response.isSuccessful()){
                    currentWeatherResponseMutableLiveData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<CurrentWeatherResponse> call, Throwable t) {
                currentWeatherResponseMutableLiveData.setValue(null);
                Log.d("Fail", "Failed retrofit");

            }
        });
        return currentWeatherResponseMutableLiveData;
    }
}
