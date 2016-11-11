package carpark;

/**
 * Created by pandorw on 11/11/2016.
 */
public abstract class Vehicle {

    String vehicleModel;
    String vehicleRegistration;
    String vehicleType;

    public Vehicle(String model, String reg, String type){
        this.vehicleModel = model;
        this.vehicleRegistration = reg;
        this.vehicleType = type;
    }

}
