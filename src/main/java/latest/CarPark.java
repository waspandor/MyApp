package latest;

/**
 * Created by pandorw on 10/11/2016.
 */
public class CarPark {

    int totalSpaces = 10;
    int remainingSpaces = totalSpaces;

    Vehicle[] cars = new Vehicle[totalSpaces];

    int currentVehicle = 0;


    public void checkAndParkIfSpace(String carName, int size) {

        Vehicle car = new Vehicle();

        car.make = carName;
        car.size = size;


        if (car.size <= 2) {

            if (remainingSpaces < car.size) {
                System.out.println("Car Park is full");
                System.out.println(remainingSpaces + " Spaces left");
            } else

                cars[currentVehicle] = car;
                parkCarAndAddVehicle(cars[currentVehicle].size);

        } else {
            System.out.println("Vehicle is too big");
        }

    }

    private void parkCarAndAddVehicle(int carSize) {

        if (carSize == 1) {
            remainingSpaces--;
        } else if (carSize == 2) {
            remainingSpaces--;
            remainingSpaces--;

        }
        System.out.println("There are now " + remainingSpaces + " spaces left");
        cars[currentVehicle].returnVehicleDetails();
        currentVehicle++;

    }

    public int checkAvailableSpaces() {
        return remainingSpaces;

    }

    public void carDetails() {

        for (int i = 0; i < currentVehicle; i++) {
            cars[i].returnVehicleDetails();
        }

    }
}








