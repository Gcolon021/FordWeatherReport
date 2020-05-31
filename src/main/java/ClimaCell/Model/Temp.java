package ClimaCell.Model;

import com.squareup.moshi.Json;
import lombok.Data;

@Data
public class Temp {
    @Json(name = "observation_time")
    private String observationTime;
    @Json(name = "min")
    private Min min;
    @Json(name = "max")
    private Max max;
}
