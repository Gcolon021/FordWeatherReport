package Location;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

//TODO Create a 'cache' for most usedZipCodes

public class LonLatLocator {

    /**
     * Currently return a single Location.LonLatZip. Eventually the goal
     * is to return an array of all desired values based on
     * the current value.
     *
     * @param zipCode
     * @return
     */

    public static LonLatZip getWithZipCode(String zipCode) {
        InputStream UsZipCodes = LonLatLocator.class.getClassLoader().getResourceAsStream("USZipCodesfrom2013GovernmentData.txt");
        LonLatZip lonLatZip = null;
        if (UsZipCodes == null) throw new IllegalArgumentException("File not found");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(UsZipCodes))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = StringUtils.split(line, ",");
                if (split[0].equals(zipCode)) {
                    lonLatZip = LonLatZip.builder().zipCode(split[0]).latitude(split[1]).longitude(split[2]).build();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lonLatZip;
    }
}
