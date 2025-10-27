public class pattern {
    

    public static void printt(int n) {
        if (n == 0)
            return;
        System.out.print("*" + " ");
        System.out.println();
        printt(n-1);
        
    }
    public static void main(String[] args) {
        
        printt(5);
    }
}
