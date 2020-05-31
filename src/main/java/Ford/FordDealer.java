package Ford;

import ClimaCell.Model.ClimaCell;
import Location.LonLatZip;
import lombok.Builder;
import lombok.Data;

@Builder @Data public class FordDealer {
    private String route;
    private String dealerCode;
    private String name;
    private String city;
    private String stateCode;
    private String actualTime;
    private String expectedTime;
    private String zipCode;
    private LonLatZip lonLatZip;
    private ClimaCell weather;

}
