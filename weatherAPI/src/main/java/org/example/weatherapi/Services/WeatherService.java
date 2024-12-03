package org.example.weatherapi.Services;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.example.weatherapi.Model.City;
import org.example.weatherapi.Model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
@Getter
@Setter
public class WeatherService
{
    Weather weatherx;
    City city;

    public WeatherService(Weather weather,City city) {
        this.weatherx = weather;
        this.city = city;
    }
    Logger log = LoggerFactory.getLogger(WeatherService.class);

    public void getTemperatureOfCity() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            URL urlCity = new URL("https://geocoding-api.open-meteo.com/v1/search?name=" + city.getName() + "&count=1&language=en&format=json");
            city = mapper.readValue(urlCity, City.class);
            URL urlWeather = new URL("https://api.open-meteo.com/v1/forecast?latitude=" + city.getLat() + "&longitude=" + city.getLon() + "&current=temperature_2m");
            log.error(urlCity.toString());

            weatherx = mapper.readValue(urlWeather, Weather.class);
            weatherx.getCurrent().setTemperature2m(weatherx.getCurrent().getTemperature2m());
            log.error(weatherx.getCurrent().getTemperature2m() + " gradusa");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
