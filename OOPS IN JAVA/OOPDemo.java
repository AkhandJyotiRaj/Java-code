// Main class to demonstrate OOP concepts
public class OOPDemo {
    public static void main(String[] args) {
        System.out.println("=== Object-Oriented Programming Demo ===\n");
        
        // Create a zoo
        Zoo myZoo = new Zoo("Wildlife Paradise");
        
        // Create different types of animals (demonstrating inheritance)
        Dog dog1 = new Dog("Buddy", 3, "Golden Retriever", true);
        Dog dog2 = new Dog("Max", 5, "German Shepherd", false);
        
        Cat cat1 = new Cat("Whiskers", 2, "Orange", true);
        Cat cat2 = new Cat("Shadow", 4, "Black", false);
        
        Bird bird1 = new Bird("Tweety", 1, "Yellow", true, 15.5);
        Bird bird2 = new Bird("Penguin", 3, "Black and White", false, 25.0);
        
        // Add animals to zoo
        myZoo.addAnimal(dog1);
        myZoo.addAnimal(dog2);
        myZoo.addAnimal(cat1);
        myZoo.addAnimal(cat2);
        myZoo.addAnimal(bird1);
        myZoo.addAnimal(bird2);
        
        // Display all animals
        myZoo.displayAllAnimals();
        
        // Demonstrate polymorphism - same method call, different behaviors
        myZoo.makeAllAnimalsSound();
        myZoo.makeAllAnimalsMove();
        
        // Demonstrate specific behaviors
        myZoo.demonstrateSpecificBehaviors();
        
        // Demonstrate encapsulation
        System.out.println("\n=== Encapsulation Demo ===");
        System.out.println("Dog's name: " + dog1.getName());
        System.out.println("Dog's age: " + dog1.getAge());
        System.out.println("Dog's breed: " + dog1.getBreed());
        
        // Demonstrate setter methods
        dog1.setAge(4);
        System.out.println("Updated dog's age: " + dog1.getAge());
        
        // Demonstrate inheritance and method overriding
        System.out.println("\n=== Inheritance and Polymorphism Demo ===");
        Animal[] animals = {dog1, cat1, bird1};
        
        for (Animal animal : animals) {
            System.out.println("\nAnimal: " + animal.getName());
            animal.makeSound();  // Polymorphism - different sounds for different animals
            animal.move();       // Polymorphism - different movements for different animals
        }
        
        // Demonstrate method overriding
        System.out.println("\n=== Method Overriding Demo ===");
        dog1.displayInfo();  // Shows breed information
        cat1.displayInfo();  // Shows color information
        bird1.displayInfo(); // Shows feather color and wing span
        
        // Demonstrate zoo statistics
        System.out.println("\n=== Zoo Statistics ===");
        System.out.println("Zoo Name: " + myZoo.getName());
        System.out.println("Total Animals: " + myZoo.getAnimalCount());
        
        // Demonstrate specific animal behaviors
        System.out.println("\n=== Specific Behaviors Demo ===");
        dog1.fetch();
        cat1.purr();
        cat1.goOutside();
        bird1.fly();
        bird1.buildNest();
        
        // Demonstrate encapsulation with validation
        System.out.println("\n=== Encapsulation with Validation Demo ===");
        dog1.setAge(-5);  // This should not change the age due to validation
        System.out.println("Dog's age after trying to set negative value: " + dog1.getAge());
        
        bird1.setWingSpan(-10.0);  // This should not change the wing span due to validation
        System.out.println("Bird's wing span after trying to set negative value: " + bird1.getWingSpan());
        
        System.out.println("\n=== OOP Demo Complete ===");
    }
}
