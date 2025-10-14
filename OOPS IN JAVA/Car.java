// Car class extending Vehicle (inheritance)
public class Car extends Vehicle {
    // Private fields specific to cars
    private int numberOfDoors;
    private int numberOfSeats;
    private String transmissionType;
    private boolean hasAirConditioning;
    private String bodyType;
    private double engineSize;
    
    // Constructor
    public Car(String brand, String model, int year, String color, double price, String fuelType,
               int numberOfDoors, int numberOfSeats, String transmissionType, 
               boolean hasAirConditioning, String bodyType, double engineSize) {
        super(brand, model, year, color, price, fuelType); // Call parent constructor
        this.numberOfDoors = numberOfDoors;
        this.numberOfSeats = numberOfSeats;
        this.transmissionType = transmissionType;
        this.hasAirConditioning = hasAirConditioning;
        this.bodyType = bodyType;
        this.engineSize = engineSize;
    }
    
    // Getter methods
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    
    public String getTransmissionType() {
        return transmissionType;
    }
    
    public boolean hasAirConditioning() {
        return hasAirConditioning;
    }
    
    public String getBodyType() {
        return bodyType;
    }
    
    public double getEngineSize() {
        return engineSize;
    }
    
    // Setter methods with validation
    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors >= 2 && numberOfDoors <= 5) {
            this.numberOfDoors = numberOfDoors;
        }
    }
    
    public void setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats >= 2 && numberOfSeats <= 8) {
            this.numberOfSeats = numberOfSeats;
        }
    }
    
    public void setTransmissionType(String transmissionType) {
        if (transmissionType != null && !transmissionType.trim().isEmpty()) {
            this.transmissionType = transmissionType;
        }
    }
    
    public void setHasAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }
    
    public void setBodyType(String bodyType) {
        if (bodyType != null && !bodyType.trim().isEmpty()) {
            this.bodyType = bodyType;
        }
    }
    
    public void setEngineSize(double engineSize) {
        if (engineSize > 0) {
            this.engineSize = engineSize;
        }
    }
    
    // Override start method (polymorphism)
    @Override
    public void start() {
        System.out.println("Starting " + getBrand() + " " + getModel() + " car...");
        super.start();
    }
    
    // Override accelerate method (polymorphism)
    @Override
    public void accelerate() {
        if (isRunning()) {
            System.out.println(getBrand() + " " + getModel() + " car is accelerating smoothly");
        } else {
            System.out.println("Cannot accelerate - car is not running");
        }
    }
    
    // Car-specific methods
    public void turnOnAC() {
        if (hasAirConditioning) {
            System.out.println("Air conditioning turned on in " + getBrand() + " " + getModel());
        } else {
            System.out.println("This car doesn't have air conditioning");
        }
    }
    
    public void turnOffAC() {
        if (hasAirConditioning) {
            System.out.println("Air conditioning turned off in " + getBrand() + " " + getModel());
        }
    }
    
    public void shiftGear(String gear) {
        if (isRunning()) {
            System.out.println("Shifting to " + gear + " gear in " + getBrand() + " " + getModel());
        } else {
            System.out.println("Cannot shift gear - car is not running");
        }
    }
    
    public void openTrunk() {
        System.out.println("Opening trunk of " + getBrand() + " " + getModel());
    }
    
    public void closeTrunk() {
        System.out.println("Closing trunk of " + getBrand() + " " + getModel());
    }
    
    // Method to check if car is spacious
    public boolean isSpacious() {
        return numberOfSeats >= 5;
    }
    
    // Method to calculate fuel efficiency (simplified)
    public double calculateFuelEfficiency() {
        double baseEfficiency = 25.0; // Base MPG
        if (engineSize > 3.0) {
            baseEfficiency -= 5.0; // Larger engines are less efficient
        }
        if (hasAirConditioning) {
            baseEfficiency -= 2.0; // AC reduces efficiency
        }
        return Math.max(baseEfficiency, 10.0); // Minimum 10 MPG
    }
    
    // Override displayInfo to include car-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Doors: " + numberOfDoors + ", Seats: " + numberOfSeats);
        System.out.println("Transmission: " + transmissionType + ", Body Type: " + bodyType);
        System.out.println("Engine Size: " + engineSize + "L, AC: " + hasAirConditioning);
        System.out.println("Fuel Efficiency: " + String.format("%.1f", calculateFuelEfficiency()) + " MPG");
    }
}
