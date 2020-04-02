package com.akshata.weather;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.akshata.weather.model.CurrentWeatherResponse;

public class WeatherViewModel extends ViewModel {

    private MutableLiveData<CurrentWeatherResponse> weatherResponseMutableLiveData;
    private WeatherRepository weatherRepository;

    public WeatherViewModel() {
        weatherRepository = WeatherRepository.getInstance();
//        weatherResponseMutableLiveData = weatherRepository.getCurrentWeather("");
    }

    public void getCurrentWeather(String cityName) {
        weatherResponseMutableLiveData = weatherRepository.getCurrentWeather(cityName);
    }

    public LiveData<CurrentWeatherResponse> getWeatherRepository() {
        return weatherResponseMutableLiveData;
    }
}