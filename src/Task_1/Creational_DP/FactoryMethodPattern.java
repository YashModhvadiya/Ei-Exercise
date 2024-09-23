package Task_1.Creational_DP;

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
        Vehicle vehicle1 = VehicleFactory.getVehicle("Car");
        vehicle1.drive();

        Vehicle vehicle2 = VehicleFactory.getVehicle("Bike");
        vehicle2.drive();
    }
}
