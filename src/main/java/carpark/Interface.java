package carpark;

import java.util.Scanner;


/**
 * Created by pandorw on 11/11/2016.
 */
public class Interface  {

    public static void main(String args[]) {

        WestminsterCarPartManager test = new WestminsterCarPartManager();


        while (true) {
            String selection = test.mainMenu();
            test.makeSelection(selection);
        }
    }

}



