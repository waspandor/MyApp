package latest;

/**
 * Created by pandorw on 10/11/2016.
 */
public class CarParkInterface {

    public static void main(String[] args) {

        CarPark park = new CarPark();
        Vehicle car = new Vehicle();

        park.checkAndParkIfSpace(car, "a", 2);
        park.checkAndParkIfSpace(car, "b", 2);
        park.checkAndParkIfSpace(car, "c", 2);
        park.checkAndParkIfSpace(car, "d", 2);
        park.checkAndParkIfSpace(car, "d", 2);
        park.checkAndParkIfSpace(car, "d", 1);
        park.checkAndParkIfSpace(car, "d", 6);

        park.carDetails();


    }
}
