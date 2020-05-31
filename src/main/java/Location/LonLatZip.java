package Location;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LonLatZip {
    private String zipCode;
    private String longitude;
    private String latitude;
}
