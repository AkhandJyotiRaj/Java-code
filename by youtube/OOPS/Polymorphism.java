public class Polymorphism {
    
    public static class Dog {
        void speak() {
            System.out.println("Bhow Bhow");
        }
    }

    public static class Cat {
        void speak() {
            System.out.println("Meow Meow");
        }
    }

    public static class Pikachu {
        void speak() {
            System.out.println("Pika Pika");
        }
    }
    public static class Human {
        void speak() {
            System.out.println("Teri ma ka bhorasa");
        }
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        Cat c = new Cat();
        Pikachu p = new Pikachu();
        Human rand = new Human();


        d.speak();
        c.speak();
        p.speak();
        rand.speak();
    }
}
