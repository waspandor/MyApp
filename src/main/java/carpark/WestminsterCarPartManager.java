package carpark;

import latest.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pandorw on 11/11/2016.
 */
public class WestminsterCarPartManager {

    int totalSpaces = 20;
    int remainingSpaces = totalSpaces;
    int currentVehicle = 0;

    // Vehicle[] cars = new Vehicle[totalSpaces];
    List<Vehicle> cars1 = new ArrayList<Vehicle>();

    static Scanner input = new Scanner(System.in);

    public void typeOfVehicle(String vehicleType) {
        checkSpaceAndParkIfAvailable(vehicleType);
    }


    public void checkSpaceAndParkIfAvailable(String vehicleType) {

        if (vehicleType.equalsIgnoreCase("van")) {

            if (totalSpaces < 2)
                System.out.println("THere is no space for a vehicle of this size");
            else
                parkVan();

        } else if (vehicleType.equalsIgnoreCase("car")) {

            if (totalSpaces < 1)
                System.out.println("THere is no space for a vehicle of this size");
            else
                parkCar();

        } else if (vehicleType.equals("motorbike")) {
            if (totalSpaces < 1)
                System.out.println("THere is no space for a vehicle of this size");
            else
                parkMotorbike();
        }
    }

    private void parkCar() {

        String Option;

        System.out.println("");
        System.out.println("Please enter the vehicle model");
        String model = input.next();

        System.out.println("Please enter vehicle registration");
        String reg = input.next();

        System.out.println("Please enter the numnber of door");
        String doors = input.next();
        int noOfDoors = Integer.parseInt(doors);

        System.out.println("Please enter vehicle colour");
        String colour = input.next();

        Car car = new Car(model, reg, noOfDoors, colour);
        //cars[currentVehicle] = car;
        cars1.add(car);
        currentVehicle++;
        remainingSpaces--;
    }


    private void parkVan() {

    }

    private void parkMotorbike() {

    }

    public void vehicleDetails() {

        if (currentVehicle != 0) {

            for (Vehicle c : cars1) {
                System.out.println(c.vehicleType);
                System.out.println(c.vehicleRegistration);
                System.out.println(c.vehicleModel);

            }

        } else
            System.out.println("There are no vehicles in the car park");
    }


    public void deleteVehicle(String registration) {

        if (currentVehicle != 0) {

            for (int i = 0; i < cars1.size(); i++) {
                if (cars1.get(i).vehicleRegistration.equalsIgnoreCase(registration)) {
                    cars1.remove(i);
                    break;
                }
            }
        }
    }


    public String mainMenu() {

        System.out.println("");
        System.out.println("Menu:");
        System.out.println("A) Add a new vehicle");
        System.out.println("D) Delete a vehicle");
        System.out.println("P) Display parked cars");
        System.out.println("S) Statistics");
        System.out.println("F) Search for car on specified day");
        System.out.println("C) Parking charges");
        System.out.println("");
        System.out.println("Please select an option:");

        String Option;
        Option = input.next();
        return Option;
    }


    public void makeSelection(String selection) {

        String Option;

        if (selection.equalsIgnoreCase("A")) {

            System.out.println("Please enter a vehicle type:");
            Option = input.next();
            checkSpaceAndParkIfAvailable(Option);
            System.out.println("Vehicle Has Been Succesfully Added");
        } else if (selection.equalsIgnoreCase("P")) {

            vehicleDetails();

        } else if (selection.equalsIgnoreCase("D")) {
            System.out.println("Please enter the registration");
            Option = input.next();
            deleteVehicle(Option);
            currentVehicle--;
            System.out.println("Vehicle has been deleted");

        } else if (selection.equalsIgnoreCase("S")) {
            System.out.println(currentVehicle);

        } else if (selection.equalsIgnoreCase("F")) {
        } else if (selection.equalsIgnoreCase("C")) {
        }
    }


}




