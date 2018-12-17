import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class PropertyMapper {

    public Property map(String[] data) throws ParseException {
        SimpleDateFormat parserSDF = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
        Date date = parserSDF.parse("Wed Oct 16 00:00:00 CEST 2013");
        Property result = new Property();
        result.setStreet(data[0]);
        result.setCity(data[1]);
        result.setZipCode(data[2]);
        result.setState(data[3]);
        result.setBeds(Integer.parseInt(data[4]));
        result.setBaths(Integer.parseInt(data[5]));
        result.setSquareFeet(Integer.parseInt(data[6]));
        result.setType(data[7]);
        result.setSaleDate(date);
        result.setPrice(Integer.parseInt(data[9]));
        result.setLatitude(Double.parseDouble(data[10]));
        result.setLongitude(Double.parseDouble(data[11]));

        return result;
    }
}
