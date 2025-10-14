// Dog class extending Animal (inheritance)
public class Dog extends Animal {
    private String breed;
    private boolean isTrained;
    
    // Constructor
    public Dog(String name, int age, String breed, boolean isTrained) {
        super(name, age, "Dog"); // Call parent constructor
        this.breed = breed;
        this.isTrained = isTrained;
    }
    
    // Getter and setter for breed
    public String getBreed() {
        return breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    public boolean isTrained() {
        return isTrained;
    }
    
    public void setTrained(boolean trained) {
        isTrained = trained;
    }
    
    // Override makeSound method (polymorphism)
    @Override
    public void makeSound() {
        System.out.println(getName() + " barks: Woof! Woof!");
    }
    
    // Override move method (polymorphism)
    @Override
    public void move() {
        System.out.println(getName() + " runs on four legs");
    }
    
    // Specific method for Dog class
    public void fetch() {
        if (isTrained) {
            System.out.println(getName() + " fetches the ball");
        } else {
            System.out.println(getName() + " doesn't know how to fetch yet");
        }
    }
    
    // Override displayInfo to include breed information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed + ", Trained: " + isTrained);
    }
}
