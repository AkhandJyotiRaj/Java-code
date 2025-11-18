public class RevisionOOps {

    public static class pokimon {
        String name;
        int price;
        int hp;

        pokimon(String name, int price, int hp) {
            this.name = name;
            this.price = price;
            this.hp = hp;
        }

        void print() {
            System.out.println(this.name+" "+ this.price+" "+ this.hp);
        }
    }
    public static void main(String[] args) {
        pokimon p1 = new pokimon("Lund", 23, 23);
        p1.print();
    }
}