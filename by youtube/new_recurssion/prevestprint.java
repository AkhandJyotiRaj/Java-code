public class prevestprint {

    public static void printt(int n) {
        
        for (int i = 0; i <= n; i++) {
            
            for (int j = 0; j <= i; j++) {
                System.out.print((n) + " ");
                n--;
                
            }
            
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        printt(10);
    }
}
