package ClimaCell.Model;

import com.squareup.moshi.Json;
import lombok.Data;

@Data
public class Min {
    @Json(name = "value")
    private Double value;
    @Json(name = "units")
    private String units;

}
