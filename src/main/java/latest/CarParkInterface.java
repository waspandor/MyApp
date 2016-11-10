package latest;

/**
 * Created by pandorw on 10/11/2016.
 */
public class CarParkInterface {

    public static void main(String[] args) {

        CarPark park = new CarPark();

        park.checkAndParkIfSpace("calica", 2);
        park.checkAndParkIfSpace("toyota", 1);

        System.out.println("Vehicle Details");
        park.carDetails();



    }
}
