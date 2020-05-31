package ClimaCell.Model;

import lombok.Data;

@Data
public class Temperatures {
    private String observation_time;
    private Temp temp;
}
