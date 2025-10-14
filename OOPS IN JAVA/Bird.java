// Bird class extending Animal (inheritance)
public class Bird extends Animal {
    private String featherColor;
    private boolean canFly;
    private double wingSpan;
    
    // Constructor
    public Bird(String name, int age, String featherColor, boolean canFly, double wingSpan) {
        super(name, age, "Bird"); // Call parent constructor
        this.featherColor = featherColor;
        this.canFly = canFly;
        this.wingSpan = wingSpan;
    }
    
    // Getter and setter methods
    public String getFeatherColor() {
        return featherColor;
    }
    
    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }
    
    public boolean canFly() {
        return canFly;
    }
    
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
    
    public double getWingSpan() {
        return wingSpan;
    }
    
    public void setWingSpan(double wingSpan) {
        if (wingSpan > 0) {
            this.wingSpan = wingSpan;
        }
    }
    
    // Override makeSound method (polymorphism)
    @Override
    public void makeSound() {
        System.out.println(getName() + " chirps: Tweet! Tweet!");
    }
    
    // Override move method (polymorphism)
    @Override
    public void move() {
        if (canFly) {
            System.out.println(getName() + " flies through the air");
        } else {
            System.out.println(getName() + " hops on the ground");
        }
    }
    
    // Specific method for Bird class
    public void fly() {
        if (canFly) {
            System.out.println(getName() + " spreads its wings and flies");
        } else {
            System.out.println(getName() + " cannot fly");
        }
    }
    
    // Method to build nest
    public void buildNest() {
        System.out.println(getName() + " builds a nest with twigs and leaves");
    }
    
    // Override displayInfo to include bird-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Feather Color: " + featherColor + ", Can Fly: " + canFly + ", Wing Span: " + wingSpan + " cm");
    }
}
