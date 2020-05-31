package ClimaCell.Model;

import com.squareup.moshi.Json;
import lombok.Data;

@Data class ObservationTime {
    @Json(name = "value")
    private String value;
}
