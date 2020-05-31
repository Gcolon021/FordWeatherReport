package ClimaCell.Model;

import com.squareup.moshi.Json;
import lombok.Data;

@Data
public class WeatherCode {
    @Json(name = "value")
    private String value;
}
