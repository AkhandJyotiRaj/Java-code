public class productfunction {
    public static int akhand(int a, int b) {
        int product = a * b;
        return product;
    }

    public static void main(String args[]) {
        int a = 3;
        int b = 5;
        int prod=akhand(a, b);
        
        System.out.print(prod);
    }
}
