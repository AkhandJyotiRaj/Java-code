// SportsCar class extending Car (inheritance)
public class SportsCar extends Car {
    private int topSpeed;
    private double zeroToSixtyTime;
    private boolean hasTurbo;
    private String driveType;
    private boolean hasSpoiler;
    private boolean hasRacingSeats;
    
    // Constructor
    public SportsCar(String brand, String model, int year, String color, double price, String fuelType,
                    int numberOfDoors, int numberOfSeats, String transmissionType, 
                    boolean hasAirConditioning, String bodyType, double engineSize,
                    int topSpeed, double zeroToSixtyTime, boolean hasTurbo, 
                    String driveType, boolean hasSpoiler, boolean hasRacingSeats) {
        super(brand, model, year, color, price, fuelType, numberOfDoors, numberOfSeats, 
              transmissionType, hasAirConditioning, bodyType, engineSize);
        this.topSpeed = topSpeed;
        this.zeroToSixtyTime = zeroToSixtyTime;
        this.hasTurbo = hasTurbo;
        this.driveType = driveType;
        this.hasSpoiler = hasSpoiler;
        this.hasRacingSeats = hasRacingSeats;
    }
    
    // Getter methods
    public int getTopSpeed() {
        return topSpeed;
    }
    
    public double getZeroToSixtyTime() {
        return zeroToSixtyTime;
    }
    
    public boolean hasTurbo() {
        return hasTurbo;
    }
    
    public String getDriveType() {
        return driveType;
    }
    
    public boolean hasSpoiler() {
        return hasSpoiler;
    }
    
    public boolean hasRacingSeats() {
        return hasRacingSeats;
    }
    
    // Setter methods with validation
    public void setTopSpeed(int topSpeed) {
        if (topSpeed > 0) {
            this.topSpeed = topSpeed;
        }
    }
    
    public void setZeroToSixtyTime(double zeroToSixtyTime) {
        if (zeroToSixtyTime > 0) {
            this.zeroToSixtyTime = zeroToSixtyTime;
        }
    }
    
    public void setHasTurbo(boolean hasTurbo) {
        this.hasTurbo = hasTurbo;
    }
    
    public void setDriveType(String driveType) {
        if (driveType != null && !driveType.trim().isEmpty()) {
            this.driveType = driveType;
        }
    }
    
    public void setHasSpoiler(boolean hasSpoiler) {
        this.hasSpoiler = hasSpoiler;
    }
    
    public void setHasRacingSeats(boolean hasRacingSeats) {
        this.hasRacingSeats = hasRacingSeats;
    }
    
    // Override accelerate method (polymorphism)
    @Override
    public void accelerate() {
        if (isRunning()) {
            System.out.println(getBrand() + " " + getModel() + " sports car accelerates with incredible speed!");
        } else {
            System.out.println("Cannot accelerate - sports car is not running");
        }
    }
    
    // Sports car-specific methods
    public void activateSportMode() {
        if (isRunning()) {
            System.out.println("Sport mode activated in " + getBrand() + " " + getModel());
            System.out.println("Engine response enhanced, suspension stiffened");
        } else {
            System.out.println("Cannot activate sport mode - sports car is not running");
        }
    }
    
    public void deactivateSportMode() {
        System.out.println("Sport mode deactivated in " + getBrand() + " " + getModel());
    }
    
    public void activateTurbo() {
        if (hasTurbo && isRunning()) {
            System.out.println("Turbo boost activated in " + getBrand() + " " + getModel());
        } else if (!hasTurbo) {
            System.out.println("This sports car doesn't have turbo");
        } else {
            System.out.println("Cannot activate turbo - sports car is not running");
        }
    }
    
    public void deactivateTurbo() {
        if (hasTurbo) {
            System.out.println("Turbo boost deactivated in " + getBrand() + " " + getModel());
        }
    }
    
    public void lowerSpoiler() {
        if (hasSpoiler) {
            System.out.println("Lowering spoiler for better aerodynamics in " + getBrand() + " " + getModel());
        } else {
            System.out.println("This sports car doesn't have a spoiler");
        }
    }
    
    public void raiseSpoiler() {
        if (hasSpoiler) {
            System.out.println("Raising spoiler in " + getBrand() + " " + getModel());
        }
    }
    
    public void launchControl() {
        if (isRunning()) {
            System.out.println("Launch control activated in " + getBrand() + " " + getModel());
            System.out.println("0-60 mph in " + zeroToSixtyTime + " seconds!");
        } else {
            System.out.println("Cannot use launch control - sports car is not running");
        }
    }
    
    // Method to check if sports car is high-performance
    public boolean isHighPerformance() {
        return topSpeed > 180 && zeroToSixtyTime < 4.0;
    }
    
    // Method to calculate power-to-weight ratio (simplified)
    public double calculatePowerToWeightRatio() {
        double estimatedPower = getEngineSize() * 100; // Simplified calculation
        double weight = 1500; // Average sports car weight
        return estimatedPower / weight;
    }
    
    // Override fuel efficiency calculation for sports cars
    @Override
    public double calculateFuelEfficiency() {
        double baseEfficiency = super.calculateFuelEfficiency();
        if (hasTurbo) {
            baseEfficiency -= 8.0; // Turbo reduces efficiency
        }
        if (isHighPerformance()) {
            baseEfficiency -= 10.0; // High performance reduces efficiency
        }
        return Math.max(baseEfficiency, 8.0);
    }
    
    // Override displayInfo to include sports car-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sports Car Features:");
        System.out.println("Top Speed: " + topSpeed + " mph, 0-60 Time: " + zeroToSixtyTime + " seconds");
        System.out.println("Turbo: " + hasTurbo + ", Drive Type: " + driveType);
        System.out.println("Spoiler: " + hasSpoiler + ", Racing Seats: " + hasRacingSeats);
        System.out.println("High Performance: " + isHighPerformance() + ", Power-to-Weight: " + 
                          String.format("%.2f", calculatePowerToWeightRatio()));
    }
}
