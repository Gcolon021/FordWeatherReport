
package ClimaCell.Model;

import com.squareup.moshi.Json;
import lombok.Data;

@Data public class Precipitation {

    @Json(name = "observation_time")
    private String observationTime;
    @Json(name = "max")
    private Max_ max;
}