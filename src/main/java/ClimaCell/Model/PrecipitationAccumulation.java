package ClimaCell.Model;

import com.squareup.moshi.Json;
import lombok.Data;

@Data
public class PrecipitationAccumulation {
    @Json(name = "value")
    private double value;
    @Json(name = "units")
    private String units;

}
