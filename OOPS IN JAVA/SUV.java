// SUV class extending Car (inheritance)
public class SUV extends Car {
    private boolean isFourWheelDrive;
    private int towingCapacity;
    private boolean hasThirdRowSeating;
    private double groundClearance;
    private boolean hasSunroof;
    
    // Constructor
    public SUV(String brand, String model, int year, String color, double price, String fuelType,
              int numberOfDoors, int numberOfSeats, String transmissionType, 
              boolean hasAirConditioning, String bodyType, double engineSize,
              boolean isFourWheelDrive, int towingCapacity, boolean hasThirdRowSeating,
              double groundClearance, boolean hasSunroof) {
        super(brand, model, year, color, price, fuelType, numberOfDoors, numberOfSeats, 
              transmissionType, hasAirConditioning, bodyType, engineSize);
        this.isFourWheelDrive = isFourWheelDrive;
        this.towingCapacity = towingCapacity;
        this.hasThirdRowSeating = hasThirdRowSeating;
        this.groundClearance = groundClearance;
        this.hasSunroof = hasSunroof;
    }
    
    // Getter methods
    public boolean isFourWheelDrive() {
        return isFourWheelDrive;
    }
    
    public int getTowingCapacity() {
        return towingCapacity;
    }
    
    public boolean hasThirdRowSeating() {
        return hasThirdRowSeating;
    }
    
    public double getGroundClearance() {
        return groundClearance;
    }
    
    public boolean hasSunroof() {
        return hasSunroof;
    }
    
    // Setter methods with validation
    public void setIsFourWheelDrive(boolean isFourWheelDrive) {
        this.isFourWheelDrive = isFourWheelDrive;
    }
    
    public void setTowingCapacity(int towingCapacity) {
        if (towingCapacity >= 0) {
            this.towingCapacity = towingCapacity;
        }
    }
    
    public void setHasThirdRowSeating(boolean hasThirdRowSeating) {
        this.hasThirdRowSeating = hasThirdRowSeating;
    }
    
    public void setGroundClearance(double groundClearance) {
        if (groundClearance > 0) {
            this.groundClearance = groundClearance;
        }
    }
    
    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }
    
    // Override accelerate method (polymorphism)
    @Override
    public void accelerate() {
        if (isRunning()) {
            System.out.println(getBrand() + " " + getModel() + " SUV accelerates with power and stability");
        } else {
            System.out.println("Cannot accelerate - SUV is not running");
        }
    }
    
    // SUV-specific methods
    public void engageFourWheelDrive() {
        if (isFourWheelDrive) {
            System.out.println("Four-wheel drive engaged in " + getBrand() + " " + getModel());
        } else {
            System.out.println("This SUV doesn't have four-wheel drive");
        }
    }
    
    public void disengageFourWheelDrive() {
        if (isFourWheelDrive) {
            System.out.println("Four-wheel drive disengaged in " + getBrand() + " " + getModel());
        }
    }
    
    public void openSunroof() {
        if (hasSunroof) {
            System.out.println("Opening sunroof in " + getBrand() + " " + getModel());
        } else {
            System.out.println("This SUV doesn't have a sunroof");
        }
    }
    
    public void closeSunroof() {
        if (hasSunroof) {
            System.out.println("Closing sunroof in " + getBrand() + " " + getModel());
        }
    }
    
    public void towTrailer(int weight) {
        if (weight <= towingCapacity) {
            System.out.println("Towing " + weight + " lbs trailer with " + getBrand() + " " + getModel());
        } else {
            System.out.println("Cannot tow " + weight + " lbs - exceeds capacity of " + towingCapacity + " lbs");
        }
    }
    
    public void offRoadMode() {
        if (isFourWheelDrive) {
            System.out.println("Activating off-road mode in " + getBrand() + " " + getModel());
        } else {
            System.out.println("Off-road mode not available - no four-wheel drive");
        }
    }
    
    // Method to check if SUV is suitable for off-road
    public boolean isOffRoadCapable() {
        return isFourWheelDrive && groundClearance > 8.0;
    }
    
    // Override fuel efficiency calculation for SUVs
    @Override
    public double calculateFuelEfficiency() {
        double baseEfficiency = super.calculateFuelEfficiency();
        if (isFourWheelDrive) {
            baseEfficiency -= 5.0; // 4WD reduces efficiency
        }
        if (hasThirdRowSeating) {
            baseEfficiency -= 2.0; // Extra weight reduces efficiency
        }
        return Math.max(baseEfficiency, 12.0);
    }
    
    // Override displayInfo to include SUV-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("SUV Features:");
        System.out.println("Four-Wheel Drive: " + isFourWheelDrive + ", Towing Capacity: " + towingCapacity + " lbs");
        System.out.println("Third Row Seating: " + hasThirdRowSeating + ", Ground Clearance: " + groundClearance + " inches");
        System.out.println("Sunroof: " + hasSunroof + ", Off-Road Capable: " + isOffRoadCapable());
    }
}
