import java.util.*;
public class wierednumber {
    
    public static void algo(long n) {
        System.out.print(n);
        if (n == 1)
            return;
            System.out.print(" ");
        if (n % 2 == 0) {
            algo(n / 2);
        }
        if (n % 2 != 0) {
            algo(n*3+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        algo(n);
    }
}
