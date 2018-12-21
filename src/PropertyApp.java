import java.util.List;

public class PropertyApp {

    public static void main(String[] args) {
        PropertyRespository pr = new PropertyRespository(new PropertyMapper());

        Property p = pr.findCheapest();

        System.out.println(p.getPrice());


        List<Property> above = pr.propertiesAbovePrice(500000);
        List<Property> zipCode = pr.propertiesForZipCode("95823");

        PropertyLogger pl = new PropertyLogger(above);
        PropertyLogger pl2 = new PropertyLogger(zipCode);

        pl.start();
        pl2.start();
    }
}
