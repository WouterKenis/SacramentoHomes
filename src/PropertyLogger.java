import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PropertyLogger extends Thread {

    private List<Property> properties;

    PropertyLogger(List<Property> properties) {
        this.properties = properties;

    }

    public void run() {

        BufferedWriter bw = null;

        try {

            bw = Files.newBufferedWriter(Paths.get("data\\PropertyLogger.txt"), StandardOpenOption.APPEND);
            bw.write("---\n");
            bw.write("Logging of properties requested on " + LocalDateTime.now() + "... \n");
            bw.write("---\n");

            for (Property p : properties) {
                System.out.println(properties.size());
                bw.write(getPropertyAsString(p) + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private String getPropertyAsString(Property property) {
        String propertyAsString = "";

        String street = property.getStreet();
        String city = property.getCity();
        String zipCode = property.getZipCode();
        String state = property.getState();
        String beds = String.valueOf(property.getBeds());
        String baths = String.valueOf(property.getBaths());
        String squareFeet = String.valueOf(property.getSquareFeet());
        String type = property.getType();
        //sale date
        String saleDate = String.valueOf(property.getSaleDate());
        //sale date
        String price = String.valueOf(property.getPrice());
        String latitude = String.valueOf(property.getLatitude());
        String longitude = String.valueOf(property.getLongitude());

        propertyAsString = street + "," + city + "," + zipCode + "," + state + "," + beds + "," + baths + "," + squareFeet + "," +
                type + "," + saleDate + "," + price + "," + latitude + "," + longitude;

        return propertyAsString;
    }
}
