package carpark;

import java.util.Scanner;


/**
 * Created by pandorw on 11/11/2016.
 */
public class Interface {

    static Scanner input = new Scanner(System.in);
    WestminsterCarPartManager test1 = new WestminsterCarPartManager();



    public static void main(String args[]) {



        while (true) {

            String selection = mainMenu();
            makeSelection(selection);
        }
    }


    public static String mainMenu() {

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


    public static void makeSelection(String selection) {

        WestminsterCarPartManager test = new WestminsterCarPartManager();

       

        String Option;

        if (selection.equals("A")) {

            System.out.println("Please enter a vehicle type:");
            Option = input.next();
            test.checkSpaceAndParkIfAvailable(Option);
            System.out.println("Vehicle Has Been Succesfully Added");


        } else if (selection.equals("D")) {
        } else if (selection.equals("P")) {
        } else if (selection.equals("D")) {
            test.vehicleDetails();
        } else if (selection.equals("S")) {
        } else if (selection.equals("F")) {
        } else if (selection.equals("C")) {
        }
    }


}



