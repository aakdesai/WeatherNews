package com.akshata.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentWeatherMain {

    @SerializedName("temp")
    @Expose
   private double temp;

    @SerializedName("humidity")
    @Expose
   private double humidity;

    @SerializedName("temp_min")
    @Expose
   private double temp_min;

    @SerializedName("temp_max")
    @Expose
   private double temp_max;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }
}
