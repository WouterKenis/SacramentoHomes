import java.util.List;

public class PropertyApp {

    public static void main(String[] args) {
        PropertyRespository pr = new PropertyRespository(new PropertyMapper());

        Property p = pr.findCheapest();

        System.out.println(p.getPrice());
    }
}
