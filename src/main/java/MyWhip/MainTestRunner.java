package MyWhip;

/**
 * Created by pandorw on 17/03/2017.
 */
public class MainTestRunner {

    public static void main (String[] args) throws Throwable {

        CarObject car = new CarObject();

        car.carDetailsCheck("YYO7XHH");
        System.out.println("\nVehicle Description \n"+car.getCarDescription());
        System.out.println("\nVehicle Make \n"+car.getCarMake());



    }

}
