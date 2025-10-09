import java.util.*;

public class printnumber {

    static int n;
    static int x = 1;
    
    public static void printt(int x){

        if (x>n) {
            return;
        }
        System.out.print(x + " ");

        printt(x+1);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your number");
        n = sc.nextInt();

        printt(x);
        
    }
}