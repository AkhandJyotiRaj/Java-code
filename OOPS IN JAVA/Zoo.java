// Main class to demonstrate OOP concepts
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private String name;
    private List<Animal> animals;
    
    // Constructor
    public Zoo(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }
    
    // Method to add animal to zoo
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " has been added to " + name);
    }
    
    // Method to remove animal from zoo
    public void removeAnimal(Animal animal) {
        if (animals.remove(animal)) {
            System.out.println(animal.getName() + " has been removed from " + name);
        } else {
            System.out.println(animal.getName() + " was not found in " + name);
        }
    }
    
    // Method to display all animals
    public void displayAllAnimals() {
        System.out.println("\n=== " + name + " Zoo Animals ===");
        for (Animal animal : animals) {
            animal.displayInfo();
            System.out.println("---");
        }
    }
    
    // Method to make all animals make sounds (polymorphism demonstration)
    public void makeAllAnimalsSound() {
        System.out.println("\n=== All Animals Making Sounds ===");
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
    
    // Method to make all animals move (polymorphism demonstration)
    public void makeAllAnimalsMove() {
        System.out.println("\n=== All Animals Moving ===");
        for (Animal animal : animals) {
            animal.move();
        }
    }
    
    // Method to demonstrate specific animal behaviors
    public void demonstrateSpecificBehaviors() {
        System.out.println("\n=== Specific Animal Behaviors ===");
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                dog.fetch();
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                cat.purr();
            } else if (animal instanceof Bird) {
                Bird bird = (Bird) animal;
                bird.fly();
                bird.buildNest();
            }
        }
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public List<Animal> getAnimals() {
        return animals;
    }
    
    // Method to get animal count
    public int getAnimalCount() {
        return animals.size();
    }
}
