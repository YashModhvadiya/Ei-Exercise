package Task_1.Creational_DP;

import java.util.Scanner;

// Product Interface
interface Vehicle {
    void drive();
}

// Concrete Product: Car
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}

// Concrete Product: Bike
class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike.");
    }
}

// Creator Class
class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("Bike")) {
            return new Bike();
        }
        return null;
    }
}

public class FactoryMethodPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter the type of vehicle you want ('Car', 'Bike') or type 'exit' to quit:");
            String vehicleType = scanner.nextLine();

            if (vehicleType.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            Vehicle vehicle = VehicleFactory.getVehicle(vehicleType);
            if (vehicle != null) {
                vehicle.drive();
            } else {
                System.out.println("Invalid vehicle type. Please enter 'Car' or 'Bike'.");
            }
        }

        scanner.close();
    }
}
