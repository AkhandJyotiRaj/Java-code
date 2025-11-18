import java.util.*;
public class printnto1 {
    
    public static void printt(int n) {
        if (n == 0)
            return;
        
        if (n == 1)
            System.out.print(n);
        else
            System.out.print(n + " ");
            
        printt(n - 1);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printt(n);
        
    }
}
