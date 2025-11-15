


public class Constructor {

    public static class Car{
        String name;
        int price;
        String model;

        Car(String name) {
            this.name = name;
        }

        Car(String name, int price) {
            this.name = name;
            this.price = price;
        }
        Car(int price, String name) {
            this.name = name;
            this.price = price;
        }

        public void print() {
            System.out.println(this.name+" "+ this.price+" "+ this.model);
        }
    } 
    
    public static void main(String[] args) {
        Car c = new Car("alto", 1200);
        
        Car c1 = new Car(1200, "Bhosara");
        c.print();
        c1.print();
    }   
}
