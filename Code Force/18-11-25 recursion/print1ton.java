import java.util.*;
public class print1ton {
    
    public static void printt(int n) {
        if (n == 0)
            return;
        printt(n - 1);

        System.out.println(n);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printt(n);
        
    }
}
