// Main class to demonstrate OOP concepts with cars
public class CarOOPDemo {
    public static void main(String[] args) {
        System.out.println("=== Car Object-Oriented Programming Demo ===\n");
        
        // Create a car dealership
        CarDealership dealership = new CarDealership("Premium Motors", "Downtown City");
        
        // Create different types of cars (demonstrating inheritance)
        Sedan sedan1 = new Sedan("Toyota", "Camry", 2023, "Silver", 28000.0, "Gasoline",
                                4, 5, "Automatic", true, "Sedan", 2.5,
                                true, "Standard", false);
        
        Sedan sedan2 = new Sedan("BMW", "5 Series", 2023, "Black", 55000.0, "Gasoline",
                               4, 5, "Automatic", true, "Sedan", 3.0,
                               true, "Luxury", true);
        
        SUV suv1 = new SUV("Ford", "Explorer", 2023, "White", 35000.0, "Gasoline",
                         4, 7, "Automatic", true, "SUV", 3.5,
                         true, 5000, true, 8.5, true);
        
        SUV suv2 = new SUV("Jeep", "Wrangler", 2023, "Red", 42000.0, "Gasoline",
                         2, 4, "Manual", true, "SUV", 3.6,
                         true, 3500, false, 10.0, false);
        
        SportsCar sportsCar1 = new SportsCar("Ferrari", "488 GTB", 2023, "Red", 250000.0, "Gasoline",
                                           2, 2, "Automatic", true, "Coupe", 3.9,
                                           205, 3.0, true, "RWD", true, true);
        
        SportsCar sportsCar2 = new SportsCar("Porsche", "911", 2023, "Yellow", 120000.0, "Gasoline",
                                           2, 2, "Manual", true, "Coupe", 3.0,
                                           191, 4.2, false, "RWD", true, true);
        
        // Add cars to dealership inventory
        dealership.addCar(sedan1);
        dealership.addCar(sedan2);
        dealership.addCar(suv1);
        dealership.addCar(suv2);
        dealership.addCar(sportsCar1);
        dealership.addCar(sportsCar2);
        
        // Display dealership inventory
        dealership.displayInventory();
        
        // Display cars by type
        dealership.displayCarsByType();
        
        // Demonstrate polymorphism
        dealership.demonstratePolymorphism();
        
        // Demonstrate specific car behaviors
        dealership.demonstrateSpecificBehaviors();
        
        // Demonstrate encapsulation
        System.out.println("\n=== Encapsulation Demo ===");
        System.out.println("Sedan 1 - Brand: " + sedan1.getBrand());
        System.out.println("Sedan 1 - Price: $" + sedan1.getPrice());
        System.out.println("Sedan 1 - Luxury Level: " + sedan1.getLuxuryLevel());
        
        // Demonstrate setter validation
        sedan1.setPrice(-1000.0); // This should not change the price
        System.out.println("Price after trying to set negative value: $" + sedan1.getPrice());
        
        // Demonstrate inheritance and method overriding
        System.out.println("\n=== Inheritance and Method Overriding Demo ===");
        Car[] cars = {sedan1, suv1, sportsCar1};
        
        for (Car car : cars) {
            System.out.println("\n" + car.getBrand() + " " + car.getModel() + ":");
            car.start();
            car.accelerate(); // Each car type accelerates differently
            car.brake();
            car.stop();
        }
        
        // Demonstrate specific car features
        System.out.println("\n=== Specific Car Features Demo ===");
        
        // Sedan features
        System.out.println("\n--- Sedan Features ---");
        sedan1.adjustSeatPosition("comfortable");
        sedan1.activateCruiseControl();
        sedan1.turnOnAC();
        System.out.println("Is Luxury: " + sedan1.isLuxury());
        
        // SUV features
        System.out.println("\n--- SUV Features ---");
        suv1.engageFourWheelDrive();
        suv1.openSunroof();
        suv1.towTrailer(3000);
        suv1.offRoadMode();
        System.out.println("Off-Road Capable: " + suv1.isOffRoadCapable());
        
        // Sports Car features
        System.out.println("\n--- Sports Car Features ---");
        sportsCar1.activateSportMode();
        sportsCar1.activateTurbo();
        sportsCar1.launchControl();
        sportsCar1.lowerSpoiler();
        System.out.println("High Performance: " + sportsCar1.isHighPerformance());
        System.out.println("Power-to-Weight Ratio: " + String.format("%.2f", sportsCar1.calculatePowerToWeightRatio()));
        
        // Demonstrate fuel efficiency calculations
        System.out.println("\n=== Fuel Efficiency Demo ===");
        System.out.println("Sedan 1 Fuel Efficiency: " + String.format("%.1f", sedan1.calculateFuelEfficiency()) + " MPG");
        System.out.println("SUV 1 Fuel Efficiency: " + String.format("%.1f", suv1.calculateFuelEfficiency()) + " MPG");
        System.out.println("Sports Car 1 Fuel Efficiency: " + String.format("%.1f", sportsCar1.calculateFuelEfficiency()) + " MPG");
        
        // Demonstrate car search functionality
        System.out.println("\n=== Car Search Demo ===");
        System.out.println("Cars by BMW:");
        for (Car car : dealership.findCarsByBrand("BMW")) {
            System.out.println("- " + car.getBrand() + " " + car.getModel());
        }
        
        System.out.println("Cars under $50,000:");
        for (Car car : dealership.findCarsByPriceRange(0, 50000)) {
            System.out.println("- " + car.getBrand() + " " + car.getModel() + " ($" + car.getPrice() + ")");
        }
        
        // Demonstrate car sales
        System.out.println("\n=== Car Sales Demo ===");
        dealership.sellCar(sedan1, 26000.0);
        dealership.sellCar(sportsCar1, 240000.0);
        
        // Display final statistics
        dealership.displayStatistics();
        
        // Demonstrate method overriding with displayInfo
        System.out.println("\n=== Method Overriding Demo ===");
        System.out.println("Remaining cars in inventory:");
        for (Car car : dealership.getInventory()) {
            car.displayInfo(); // Each car type displays different information
            System.out.println("---");
        }
        
        System.out.println("\n=== OOP Demo Complete ===");
        System.out.println("This demo showcased:");
        System.out.println("✓ Classes and Objects");
        System.out.println("✓ Inheritance (Vehicle -> Car -> Sedan/SUV/SportsCar)");
        System.out.println("✓ Polymorphism (Method overriding and runtime polymorphism)");
        System.out.println("✓ Encapsulation (Private fields with getters/setters)");
        System.out.println("✓ Composition (CarDealership contains Cars)");
        System.out.println("✓ Method Overriding (Different behaviors for different car types)");
        System.out.println("✓ Data Validation (Setter methods with validation)");
    }
}
