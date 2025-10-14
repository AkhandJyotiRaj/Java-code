// Cat class extending Animal (inheritance)
public class Cat extends Animal {
    private String color;
    private boolean isIndoor;
    
    // Constructor
    public Cat(String name, int age, String color, boolean isIndoor) {
        super(name, age, "Cat"); // Call parent constructor
        this.color = color;
        this.isIndoor = isIndoor;
    }
    
    // Getter and setter methods
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean isIndoor() {
        return isIndoor;
    }
    
    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }
    
    // Override makeSound method (polymorphism)
    @Override
    public void makeSound() {
        System.out.println(getName() + " meows: Meow! Meow!");
    }
    
    // Override move method (polymorphism)
    @Override
    public void move() {
        System.out.println(getName() + " walks gracefully");
    }
    
    // Specific method for Cat class
    public void purr() {
        System.out.println(getName() + " purrs contentedly");
    }
    
    // Method to check if cat can go outside
    public void goOutside() {
        if (isIndoor) {
            System.out.println(getName() + " is an indoor cat and stays inside");
        } else {
            System.out.println(getName() + " goes outside to explore");
        }
    }
    
    // Override displayInfo to include color information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Color: " + color + ", Indoor: " + isIndoor);
    }
}
