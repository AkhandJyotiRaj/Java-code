public class One_GCDOfTwoNumber {

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    
    public static void main(String[] args) {
        
        int a = 20;
        int b = 28;
        int hcf = 1;
        for (int i = 1; i <= Math.min(a, b); i++) {

            if (a % i == 0 && b % i == 0) {
                hcf = i;
            }
        }
        System.out.println(gcd(a,b));
    }
}
