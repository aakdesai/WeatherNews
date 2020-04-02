package com.akshata.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.akshata.weather.model.CurrentWeatherResponse;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private WeatherViewModel weatherViewModel;
    EditText cityEditText;
    TextView cityDisplay;
    TextView minTemp;
    TextView maxTemp;
    TextView currentWeatherTV;
    TextView humidity;
    Button displayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityEditText = findViewById(R.id.cityEditText);
        cityDisplay = findViewById(R.id.cityDisplay);
        minTemp = findViewById(R.id.minTemp);
        maxTemp = findViewById(R.id.maxTemp);
        currentWeatherTV = findViewById(R.id.currentWeather);
        humidity = findViewById(R.id.humidity);
        displayButton = findViewById(R.id.displayButton);

        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        weatherViewModel.getCurrentWeather(cityEditText.getText().toString());
        weatherViewModel.getWeatherRepository().observe(this, new Observer<CurrentWeatherResponse>() {
            @Override
            public void onChanged(CurrentWeatherResponse currentWeatherResponse) {
                Toast.makeText(MainActivity.this, currentWeatherResponse.getCityName(), Toast.LENGTH_SHORT).show();
                displayCurrentWeather(currentWeatherResponse);
            }
        });


    }

    private void displayCurrentWeather(CurrentWeatherResponse currentResponse) {

        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double min_Temp = currentResponse.getMain().getTemp_min();
                Double max_Temp = currentResponse.getMain().getTemp_max();
                Double current_weather = currentResponse.getMain().getTemp();
                Double humid = currentResponse.getMain().getHumidity();

                cityDisplay.setText(currentResponse.getCityName());
                minTemp.setText(min_Temp.toString());
                maxTemp.setText(max_Temp.toString());
                humidity.setText(humid.toString());
                currentWeatherTV.setText(current_weather.toString());

                Log.d("Hello", "I am here");
            }
        });


    }


}

