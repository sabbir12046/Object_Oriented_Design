//*************************************************************************
// TITLE : A java program to demostrate Interface segregation principle
// AUTHOR : MD SABBIR HASAN, UNDERGRADUATE STUDENT (2ND YEAR) Of KHULNA UNIVERSITY
//*************************************************************************


import java.util.ArrayList;
import java.util.List;

/**
 * Interface defining the behavior of a vehicle.
 */
interface Vehicle {
    void start();
    void stop();
}

/**
 * Interface defining the behavior of a car.
 */
interface Car extends Vehicle {
    void drive();
}

/**
 * Interface defining the behavior of a electric car.
 */
interface ElectricCar extends Car {
    void charge();
}

/**
 * Interface defining the behavior of a gas car.
 */
interface GasCar extends Car {
    void refuel();
}

/**
 * Class representing a generic car.
 */
class CarImpl implements Car {
    private String brand;

    public CarImpl(String brand) {
        this.brand = brand;
    }

    @Override
    public void start() {
        System.out.println(brand + " car is starting.");
    }

    @Override
    public void stop() {
        System.out.println(brand + " car is stopping.");
    }

    @Override
    public void drive() {
        System.out.println(brand + " car is driving.");
    }
}

/**
 * Class representing an electric car.
 */
class ElectricCarImpl extends CarImpl implements ElectricCar {
    public ElectricCarImpl(String brand) {
        super(brand);
    }

    @Override
    public void charge() {
        System.out.println("Charging " + super.brand + " electric car.");
    }
}

/**
 * Class representing a gas car.
 */
class GasCarImpl extends CarImpl implements GasCar {
    public GasCarImpl(String brand) {
        super(brand);
    }

    @Override
    public void refuel() {
        System.out.println("Refueling " + super.brand + " gas car.");
    }
}

/**
 * Class representing a car dealership.
 */
class CarDealership {
    private List<Car> cars;

    public CarDealership() {
        cars = new ArrayList<>();
    }

    /**
     * Adds a car to the dealership inventory.
     *
     * @param car The car to be added
     */
    public void addCar(Car car) {
        cars.add(car);
    }

    /**
     * Drives all cars in the dealership inventory.
     */
    public void driveAllCars() {
        for (Car car : cars) {
            car.start();
            car.drive();
            car.stop();
        }
    }
}

public class Interface_Segregation_Principle {
    public static void main(String[] args) {
        // Create a car dealership
        CarDealership dealership = new CarDealership();

        // Add electric cars to the dealership
        ElectricCarImpl electricCar1 = new ElectricCarImpl("Tesla");
        ElectricCarImpl electricCar2 = new ElectricCarImpl("Nissan");
        dealership.addCar(electricCar1);
        dealership.addCar(electricCar2);

        // Add gas cars to the dealership
        GasCarImpl gasCar1 = new GasCarImpl("Toyota");
        GasCarImpl gasCar2 = new GasCarImpl("Honda");
        dealership.addCar(gasCar1);
        dealership.addCar(gasCar2);

        // Drive all cars in the dealership
        dealership.driveAllCars();
    }
}
