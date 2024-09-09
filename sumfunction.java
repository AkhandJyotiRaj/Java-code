import java.util.*;

    
public class sumfunction {
    public static void akhand(int a, int b){
        int sum = a+b;
        System.out.print(sum);
        return;
    }

    public static void main(String args[]) {
       
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        akhand(x , y);
    }
}
