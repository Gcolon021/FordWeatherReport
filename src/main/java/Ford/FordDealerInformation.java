package Ford;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FordDealerInformation {

    /*
    Both of these files are never written and for this reason they will remain as resource only files.
     */

    // FordDealer --> expose at endpoint somewhere so we can get data outside of jar and modify if nessecary
    private final static URL fordDealershipInformation = FordDealerInformation.class.getClassLoader().getResource("DealerInformation.csv");
    private final static URL fordDealerLocationInformation = FordDealerInformation.class.getClassLoader().getResource("Hartford CMT Routing V 49.csv");

    public static ArrayList<FordDealer> loadFordData() {
        ArrayList<FordDealer> fordDealers = new ArrayList<>();
        if (fordDealershipInformation == null) throw new IllegalArgumentException();
        try {
            // Must have charsetName set to UTF-8 to remove ï»¿ from beginning of .csv file
            Reader fileReader = new FileReader(fordDealershipInformation.getPath().replaceAll("%20", " "));
            Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(fileReader);
            for (CSVRecord record : records) {
                FordDealer build = FordDealer.builder()
                        .route(record.get(0))
                        .dealerCode(record.get(1))
                        .name(record.get(2))
                        .city(record.get(3))
                        .stateCode(record.get(4))
                        .actualTime(record.get(5))
                        .expectedTime(record.get(6))
                        .zipCode(record.get(7))
                        .build();

                fordDealers.add(build);
            }

            } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fordDealers;
    }

    /*
    This method was utilized to aggregate needed data from two different files matching on a dealer code
    it will not be utilized in production but could be useful at a later date and will be left here for that
    purpose.

     */
    public static void appendZipCodeToDI() {
        try {
            if (fordDealershipInformation == null || fordDealerLocationInformation == null)
                throw new IllegalArgumentException();
            Reader locationCSV = new FileReader(fordDealerLocationInformation.getPath().replaceAll("%20", " "));
            Reader dealershipCSV = new FileReader(fordDealershipInformation.getPath().replaceAll("%20", " "));
            PrintWriter writer = new PrintWriter("DealerInformation.csv", StandardCharsets.UTF_8);

            Iterable<CSVRecord> locInfoRecord = CSVFormat.RFC4180.parse(locationCSV);
            for (CSVRecord locInfo : locInfoRecord) {
                Iterable<CSVRecord> dealerInfoRecord = CSVFormat.RFC4180.parse(dealershipCSV);
                for (CSVRecord dealerInfo : dealerInfoRecord) {
                    if (dealerInfo.get(2).equals(locInfo.get(1))){
                        System.out.println("found");
                        writer.println(
                                locInfo.get(0) + ","
                                + locInfo.get(1) + ","
                                + locInfo.get(2) + ","
                                + locInfo.get(3) + ","
                                + locInfo.get(4) + ","
                                + locInfo.get(5) + ","
                                + locInfo.get(6) + ","
                                + dealerInfo.get(10));
                        writer.flush();
                        break;
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}