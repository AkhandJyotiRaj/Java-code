// Base class demonstrating encapsulation and inheritance
public class Animal {
    // Private fields (encapsulation)
    private String name;
    private int age;
    private String species;
    private boolean isAlive;
    
    // Constructor
    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.isAlive = true;
    }
    
    // Getter methods (encapsulation)
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getSpecies() {
        return species;
    }
    
    public boolean isAlive() {
        return isAlive;
    }
    
    // Setter methods (encapsulation)
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }
    
    // Virtual method (can be overridden by subclasses)
    public void makeSound() {
        System.out.println(name + " makes a generic animal sound");
    }
    
    // Method that can be overridden
    public void move() {
        System.out.println(name + " moves around");
    }
    
    // Method to display animal information
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Species: " + species);
    }
    
    // Method to simulate death
    public void die() {
        isAlive = false;
        System.out.println(name + " has passed away");
    }
}
