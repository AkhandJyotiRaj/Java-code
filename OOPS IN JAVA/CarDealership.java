// CarDealership class to manage cars demonstrating composition and aggregation
import java.util.ArrayList;
import java.util.List;

public class CarDealership {
    private String dealershipName;
    private String location;
    private List<Car> inventory;
    private double totalRevenue;
    private int carsSold;
    
    // Constructor
    public CarDealership(String dealershipName, String location) {
        this.dealershipName = dealershipName;
        this.location = location;
        this.inventory = new ArrayList<>();
        this.totalRevenue = 0.0;
        this.carsSold = 0;
    }
    
    // Getter methods
    public String getDealershipName() {
        return dealershipName;
    }
    
    public String getLocation() {
        return location;
    }
    
    public List<Car> getInventory() {
        return inventory;
    }
    
    public double getTotalRevenue() {
        return totalRevenue;
    }
    
    public int getCarsSold() {
        return carsSold;
    }
    
    // Setter methods
    public void setDealershipName(String dealershipName) {
        if (dealershipName != null && !dealershipName.trim().isEmpty()) {
            this.dealershipName = dealershipName;
        }
    }
    
    public void setLocation(String location) {
        if (location != null && !location.trim().isEmpty()) {
            this.location = location;
        }
    }
    
    // Method to add car to inventory
    public void addCar(Car car) {
        inventory.add(car);
        System.out.println("Added " + car.getBrand() + " " + car.getModel() + " to inventory");
    }
    
    // Method to remove car from inventory
    public void removeCar(Car car) {
        if (inventory.remove(car)) {
            System.out.println("Removed " + car.getBrand() + " " + car.getModel() + " from inventory");
        } else {
            System.out.println("Car not found in inventory");
        }
    }
    
    // Method to sell a car
    public boolean sellCar(Car car, double sellingPrice) {
        if (inventory.contains(car)) {
            inventory.remove(car);
            totalRevenue += sellingPrice;
            carsSold++;
            System.out.println("Sold " + car.getBrand() + " " + car.getModel() + " for $" + sellingPrice);
            return true;
        } else {
            System.out.println("Car not available for sale");
            return false;
        }
    }
    
    // Method to display all cars in inventory
    public void displayInventory() {
        System.out.println("\n=== " + dealershipName + " Inventory ===");
        System.out.println("Location: " + location);
        System.out.println("Total Cars: " + inventory.size());
        
        if (inventory.isEmpty()) {
            System.out.println("No cars in inventory");
        } else {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println("\n--- Car " + (i + 1) + " ---");
                inventory.get(i).displayInfo();
            }
        }
    }
    
    // Method to display cars by type
    public void displayCarsByType() {
        System.out.println("\n=== Cars by Type ===");
        
        int sedanCount = 0, suvCount = 0, sportsCarCount = 0, otherCount = 0;
        
        for (Car car : inventory) {
            if (car instanceof Sedan) {
                sedanCount++;
            } else if (car instanceof SUV) {
                suvCount++;
            } else if (car instanceof SportsCar) {
                sportsCarCount++;
            } else {
                otherCount++;
            }
        }
        
        System.out.println("Sedans: " + sedanCount);
        System.out.println("SUVs: " + suvCount);
        System.out.println("Sports Cars: " + sportsCarCount);
        System.out.println("Other Cars: " + otherCount);
    }
    
    // Method to demonstrate polymorphism with all cars
    public void demonstratePolymorphism() {
        System.out.println("\n=== Polymorphism Demo ===");
        for (Car car : inventory) {
            System.out.println("\n" + car.getBrand() + " " + car.getModel() + ":");
            car.start();
            car.accelerate();
            car.brake();
            car.stop();
        }
    }
    
    // Method to demonstrate specific car behaviors
    public void demonstrateSpecificBehaviors() {
        System.out.println("\n=== Specific Car Behaviors ===");
        for (Car car : inventory) {
            System.out.println("\n" + car.getBrand() + " " + car.getModel() + ":");
            
            if (car instanceof Sedan) {
                Sedan sedan = (Sedan) car;
                sedan.adjustSeatPosition("comfortable");
                sedan.activateCruiseControl();
            } else if (car instanceof SUV) {
                SUV suv = (SUV) car;
                suv.engageFourWheelDrive();
                suv.offRoadMode();
            } else if (car instanceof SportsCar) {
                SportsCar sportsCar = (SportsCar) car;
                sportsCar.activateSportMode();
                sportsCar.launchControl();
            }
        }
    }
    
    // Method to find cars by brand
    public List<Car> findCarsByBrand(String brand) {
        List<Car> foundCars = new ArrayList<>();
        for (Car car : inventory) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                foundCars.add(car);
            }
        }
        return foundCars;
    }
    
    // Method to find cars by price range
    public List<Car> findCarsByPriceRange(double minPrice, double maxPrice) {
        List<Car> foundCars = new ArrayList<>();
        for (Car car : inventory) {
            if (car.getPrice() >= minPrice && car.getPrice() <= maxPrice) {
                foundCars.add(car);
            }
        }
        return foundCars;
    }
    
    // Method to calculate average car price
    public double calculateAveragePrice() {
        if (inventory.isEmpty()) {
            return 0.0;
        }
        
        double totalPrice = 0.0;
        for (Car car : inventory) {
            totalPrice += car.getPrice();
        }
        return totalPrice / inventory.size();
    }
    
    // Method to display dealership statistics
    public void displayStatistics() {
        System.out.println("\n=== Dealership Statistics ===");
        System.out.println("Dealership: " + dealershipName);
        System.out.println("Location: " + location);
        System.out.println("Cars in Inventory: " + inventory.size());
        System.out.println("Cars Sold: " + carsSold);
        System.out.println("Total Revenue: $" + String.format("%.2f", totalRevenue));
        System.out.println("Average Car Price: $" + String.format("%.2f", calculateAveragePrice()));
    }
}
