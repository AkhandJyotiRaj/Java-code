import java.util.*;

public class arisedpowerb {

    // Easy 

    public static int pow(int a, int b) {
        
        if (b == 0) {
            return 1;
        }
        int call = pow(a,b/2);
        if (b % 2 == 0)
            return call * call;
        else
            return a * call * call; 
    }
    
    // hard

    // public static int pow(int a, int b) {
        
    //     if (b == 0)
    //         return 1;

    //     return a* pow(a, b - 1);
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a");
        int a = sc.nextInt();
        System.out.println("Enter b");
        int b = sc.nextInt();

        System.out.println(pow(a, b));
    }
}
