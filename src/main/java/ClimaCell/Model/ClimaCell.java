package ClimaCell.Model;

import com.squareup.moshi.Json;
import lombok.Data;

import java.util.List;

/**
 * This class is utilized to Access Clima Cell Data.
 * Additionally, this class is utilized by square/Moshi to parse Json from Clima Cell;
 */

/*
@Data recommended in a code review. This comes from the lombok Library and generates
all Getters, Setters, ToString, Equals, and HashCode. Generally used for POJOs.
 */

@Data
public class ClimaCell {
    @Json(name = "temp")
    private List<Temp> temp = null;
    @Json(name = "precipitation_accumulation")
    private PrecipitationAccumulation precipitationAccumulation;
    @Json(name = "precipitation")
    private List<Precipitation> precipitation = null;
    @Json(name = "weather_code")
    private WeatherCode weatherCode;
    @Json(name = "observation_time")
    private ObservationTime observationTime;
    @Json(name = "lat")
    private Double lat;
    @Json(name = "lon")
    private Double lon;
}