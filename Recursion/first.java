package Recursion;

public class first {

    public static int mult(int n) {
        if (n == 1)
            return 1;

        return n * mult(n-1);
    }

    public static void main(String args[]) {
        
        System.out.print(mult(5));
    }
}
