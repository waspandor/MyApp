package carpark;

/**
 * Created by pandorw on 11/11/2016.
 */
public class Car extends Vehicle {

    int noOfDoors;
    String carColour;
    String vehicleType = "car";

    public Car(String vehicleModel, String vehicleRegistration,int noOfDoors, String carColour){

        super(vehicleModel, vehicleRegistration,"Car");
        this.noOfDoors = noOfDoors;
        this.carColour = carColour;
    }

    public void returnVehicleDetails(){
        System.out.println(vehicleModel+ carColour + noOfDoors+ vehicleRegistration);
    }




}
