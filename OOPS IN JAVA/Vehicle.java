// Base class for all vehicles demonstrating encapsulation and inheritance
public class Vehicle {
    // Private fields (encapsulation)
    private String brand;
    private String model;
    private int year;
    private String color;
    private double price;
    private boolean isRunning;
    private int mileage;
    private String fuelType;
    
    // Constructor
    public Vehicle(String brand, String model, int year, String color, double price, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.fuelType = fuelType;
        this.isRunning = false;
        this.mileage = 0;
    }
    
    // Getter methods (encapsulation)
    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public String getColor() {
        return color;
    }
    
    public double getPrice() {
        return price;
    }
    
    public boolean isRunning() {
        return isRunning;
    }
    
    public int getMileage() {
        return mileage;
    }
    
    public String getFuelType() {
        return fuelType;
    }
    
    // Setter methods with validation (encapsulation)
    public void setBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand;
        }
    }
    
    public void setModel(String model) {
        if (model != null && !model.trim().isEmpty()) {
            this.model = model;
        }
    }
    
    public void setYear(int year) {
        if (year >= 1900 && year <= 2024) {
            this.year = year;
        }
    }
    
    public void setColor(String color) {
        if (color != null && !color.trim().isEmpty()) {
            this.color = color;
        }
    }
    
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }
    
    public void setMileage(int mileage) {
        if (mileage >= 0) {
            this.mileage = mileage;
        }
    }
    
    public void setFuelType(String fuelType) {
        if (fuelType != null && !fuelType.trim().isEmpty()) {
            this.fuelType = fuelType;
        }
    }
    
    // Virtual methods (can be overridden by subclasses)
    public void start() {
        if (!isRunning) {
            isRunning = true;
            System.out.println(brand + " " + model + " has been started");
        } else {
            System.out.println(brand + " " + model + " is already running");
        }
    }
    
    public void stop() {
        if (isRunning) {
            isRunning = false;
            System.out.println(brand + " " + model + " has been stopped");
        } else {
            System.out.println(brand + " " + model + " is already stopped");
        }
    }
    
    public void accelerate() {
        if (isRunning) {
            System.out.println(brand + " " + model + " is accelerating");
        } else {
            System.out.println("Cannot accelerate - vehicle is not running");
        }
    }
    
    public void brake() {
        System.out.println(brand + " " + model + " is braking");
    }
    
    // Method to add mileage
    public void addMileage(int miles) {
        if (miles > 0) {
            mileage += miles;
            System.out.println("Added " + miles + " miles. Total mileage: " + mileage);
        }
    }
    
    // Method to display vehicle information
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
        System.out.println("Color: " + color + ", Price: $" + price + ", Fuel Type: " + fuelType);
        System.out.println("Mileage: " + mileage + " miles, Running: " + isRunning);
    }
    
    // Method to calculate age
    public int getAge() {
        return 2024 - year;
    }
    
    // Method to check if vehicle is vintage (older than 25 years)
    public boolean isVintage() {
        return getAge() > 25;
    }
}
