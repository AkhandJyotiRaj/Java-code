import java.util.*;

public class nfactorial {
    
    public static int factoril(int n) {

        if (n == 1) {
            return 1;
        }

        int reuslt = n * factoril(n - 1);
        return reuslt;

    }
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        factoril(n);
    }
}
