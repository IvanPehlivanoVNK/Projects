package org.example.weatherapi.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;


@Setter
@Getter
@Repository
public class Weather {
    private double latitude;
    private double longitude;

    @JsonProperty("generationtime_ms")
    private double generationTimeMs;

    @JsonProperty("utc_offset_seconds")
    private int utcOffsetSeconds;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("timezone_abbreviation")
    private String timezoneAbbreviation;

    private int elevation;


    @JsonProperty("hourly")
    private Hourly hourly;

    private Current current;
    private CurrentUnits current_units;

    @Data
    public static class CurrentUnits {
        private String time;
        private String interval;
        @JsonProperty("temperature_2m")
        private String temperature2m;

        // Getters and Setters
    }
    @Data
    public static class Hourly {
        private List<String> time;

        @JsonProperty("temperature_2m")
        private List<Double> temperature2m;

        @JsonProperty("wind_speed_10m")
        private List<Double> windSpeed10m;
    }
    @Data
    public static class Current {
        private String time;
        private int interval;
        @JsonProperty("temperature_2m")
        private double temperature2m;


    }

    public Weather( ) {

    }
}
