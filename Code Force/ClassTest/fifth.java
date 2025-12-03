import java.util.*;

public class fifth {
    static final long mod = 1000000007;

    public static long beat(long n) {
        if (n == 0)
            return 1;
        if (n < 1)
            return 0;

        long ways = 0;
        for (int i = 1; i <= n; i++) {
            ways = (ways + beat(n - i)) % mod;
        }
        return ways;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number here : ");
        int n = sc.nextInt();

        System.out.println(beat(n));

        


    }
}
