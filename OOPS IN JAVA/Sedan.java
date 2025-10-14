// Sedan class extending Car (inheritance)
public class Sedan extends Car {
    private boolean hasTrunk;
    private String luxuryLevel;
    private boolean hasLeatherSeats;
    
    // Constructor
    public Sedan(String brand, String model, int year, String color, double price, String fuelType,
                int numberOfDoors, int numberOfSeats, String transmissionType, 
                boolean hasAirConditioning, String bodyType, double engineSize,
                boolean hasTrunk, String luxuryLevel, boolean hasLeatherSeats) {
        super(brand, model, year, color, price, fuelType, numberOfDoors, numberOfSeats, 
              transmissionType, hasAirConditioning, bodyType, engineSize);
        this.hasTrunk = hasTrunk;
        this.luxuryLevel = luxuryLevel;
        this.hasLeatherSeats = hasLeatherSeats;
    }
    
    // Getter methods
    public boolean hasTrunk() {
        return hasTrunk;
    }
    
    public String getLuxuryLevel() {
        return luxuryLevel;
    }
    
    public boolean hasLeatherSeats() {
        return hasLeatherSeats;
    }
    
    // Setter methods
    public void setHasTrunk(boolean hasTrunk) {
        this.hasTrunk = hasTrunk;
    }
    
    public void setLuxuryLevel(String luxuryLevel) {
        if (luxuryLevel != null && !luxuryLevel.trim().isEmpty()) {
            this.luxuryLevel = luxuryLevel;
        }
    }
    
    public void setHasLeatherSeats(boolean hasLeatherSeats) {
        this.hasLeatherSeats = hasLeatherSeats;
    }
    
    // Override accelerate method (polymorphism)
    @Override
    public void accelerate() {
        if (isRunning()) {
            System.out.println(getBrand() + " " + getModel() + " sedan accelerates smoothly and quietly");
        } else {
            System.out.println("Cannot accelerate - sedan is not running");
        }
    }
    
    // Sedan-specific methods
    public void adjustSeatPosition(String position) {
        System.out.println("Adjusting seat to " + position + " position in " + getBrand() + " " + getModel());
    }
    
    public void activateCruiseControl() {
        if (isRunning()) {
            System.out.println("Cruise control activated in " + getBrand() + " " + getModel() + " sedan");
        } else {
            System.out.println("Cannot activate cruise control - sedan is not running");
        }
    }
    
    public void deactivateCruiseControl() {
        System.out.println("Cruise control deactivated in " + getBrand() + " " + getModel() + " sedan");
    }
    
    // Method to check if sedan is luxury
    public boolean isLuxury() {
        return luxuryLevel.equalsIgnoreCase("luxury") || luxuryLevel.equalsIgnoreCase("premium");
    }
    
    // Override fuel efficiency calculation for sedans
    @Override
    public double calculateFuelEfficiency() {
        double baseEfficiency = super.calculateFuelEfficiency();
        if (isLuxury()) {
            baseEfficiency -= 3.0; // Luxury features reduce efficiency
        }
        return Math.max(baseEfficiency, 15.0);
    }
    
    // Override displayInfo to include sedan-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sedan Features:");
        System.out.println("Has Trunk: " + hasTrunk + ", Luxury Level: " + luxuryLevel);
        System.out.println("Leather Seats: " + hasLeatherSeats + ", Is Luxury: " + isLuxury());
    }
}
