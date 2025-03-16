// Interface for Insurable vehicles
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation: Getters
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    // Abstract method
    public abstract double calculateRentalCost(int days);
}

// Car class implementing Insurable
class Car extends Vehicle implements Insurable {
    private String policyNumber;

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) { return getRentalRate() * days; }
    public double calculateInsurance() { return 5000; }
    public String getInsuranceDetails() { return "Car Insurance Policy: " + policyNumber; }
}

// Bike class implementing Insurable
class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) { return getRentalRate() * days; }
    public double calculateInsurance() { return 1500; }
    public String getInsuranceDetails() { return "Bike Insurance Policy: " + policyNumber; }
}

// Truck class implementing Insurable
class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) { return getRentalRate() * days + 2000; } // Additional charge
    public double calculateInsurance() { return 8000; }
    public String getInsuranceDetails() { return "Truck Insurance Policy: " + policyNumber; }
}


public class VehicleRental {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car("CAR123", 2000, "CAR-INS-001"),
                new Bike("BIKE456", 500, "BIKE-INS-002"),
                new Truck("TRUCK789", 4000, "TRUCK-INS-003")
        };

        int days = 5;
        for (Vehicle v : vehicles) {
            System.out.println("Vehicle: " + v.getType() + " (" + v.getVehicleNumber() + ")");
            System.out.println("Rental Cost for " + days + " days: " + v.calculateRentalCost(days));
            System.out.println("Insurance: " + ((Insurable)v).calculateInsurance());
            System.out.println(((Insurable)v).getInsuranceDetails());
            System.out.println("-----------------------------");
        }
    }
}
