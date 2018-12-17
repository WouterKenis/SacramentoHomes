import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyRespository {

    List<Property> properties = new ArrayList<>();
    private PropertyMapper propertyMapper;

    public PropertyRespository(PropertyMapper propertyMapper) {

        this.propertyMapper = propertyMapper;

        Path path = Paths.get("data\\sacramentorealestatetransactions.csv");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("street")) {
                    properties.add(propertyMapper.map(line.split(",")));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Property> propertiesAbovePrice(int price) {
        List<Property> resultProperties = new ArrayList<>();

        properties.stream().filter(p -> p.getPrice() > price).forEach(p -> resultProperties.add(p));

        return resultProperties;
    }

    public List<Property> propertiesForZipCode(String zip) {
        List<Property> resultProperties = new ArrayList<>();

        properties.stream().filter(p -> p.getZipCode().equalsIgnoreCase(zip)).forEach(p -> resultProperties.add(p));

        return resultProperties;
    }

    public List<Property> propertiesSoldAfter(Date date) {
        List<Property> resultProperties = new ArrayList<>();

        properties.stream().filter(p -> p.getSaleDate().after(date)).forEach(p -> resultProperties.add(p));

        return resultProperties;
    }

    public Property findCheapest() {
        Property resultProperty = null;

        resultProperty = properties.stream()
                .filter(p -> p.getBeds() >= 3 && p.getSquareFeet() >= 1000 && p.getCity().equalsIgnoreCase("Sacramento"))
                .sorted(Comparator.comparing(Property::getPrice)).collect(Collectors.toList()).get(0);

        return resultProperty;
    }
}
