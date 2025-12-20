import java.util.*;

public class DpFirstprogram {

    public static int recursionn(int n) {
        if (n <= 1)
            return n;
        return recursionn(n-1)+ recursionn(n-2);
    }
    
        public static void main(String[] args) {
            
        }
}
