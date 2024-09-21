public class practice {

    public static int largest(int num[]) {
        
        int large = Integer.MAX_VALUE;
        for (int i = 0; i < num.length;i++){
            if (large > num[i]) {
                large = num[i];
            }
        }
        return large;
    }
    public static void main(String args[]) {
        
        int num[] = { 2, 4, 5, 3, 5, 3, 3, 19 };
        largest(num);
        System.out.print(largest(num));
    }
}
