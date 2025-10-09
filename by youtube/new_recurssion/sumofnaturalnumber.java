public class sumofnaturalnumber {

    public static int sum(int n, int ans) {
        
        if (n == 0)
            return ans;
        return sum(n / 10, n % 10 + ans);
    }
    
    public static void main(String[] args) {
        
        int n = 3456;


        System.out.println(sum(n, 0));

    }
}
