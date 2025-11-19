public class Fraction {

    public static class Frac {
        int num;
        int den;

        Frac(int num, int den) {
            this.num = num;
            this.den = den;
        }

        void print() {
            System.out.println(num + "/" + den);
        }

        void add(Frac f2) {
            num = num * f2.den + den * f2.num;
            den = den * f2.den;
        }

        void multi(Frac f) {
            num = f.num * num;
            den = f.den * den;
        }

        void devide(Frac f) {
            num = num * f.den;
            den = den * f.num;
        }
    }

    public static void main(String[] args) {
        Frac f1 = new Frac(3, 4);
        f1.print();
        Frac f2 = new Frac(2, 5);
        // f1.add(f2);f
        f1.print();
        f1.devide(f2);
        f1.print();
    }
}
