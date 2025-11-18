import java.util.*;
public class printrecursio {
    
    public static void printt(int n) {
        if (n == 0)
            return;
        System.out.println("I love Recursion");
        printt(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printt(n);
    }
}