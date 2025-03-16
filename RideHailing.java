// Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate/KM: Rs." + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

// Car subclass
class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * 15;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Bike subclass
class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * 7;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Auto subclass
class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * 10;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}


public class RideHailing {
    public static void main(String[] args) {
        Vehicle[] rides = {
                new Car("C001", "Rahul", 15),
                new Bike("B101", "Amit", 7),
                new Auto("A501", "Suresh", 10)
        };

        for (Vehicle v : rides) {
            v.getVehicleDetails();
            double fare = v.calculateFare(10); // Example distance = 10 km
            System.out.println("Fare for 10 KM: Rs." + fare);
            System.out.println("---------------------------");
        }
    }
}
