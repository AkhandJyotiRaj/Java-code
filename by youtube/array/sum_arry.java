public class sum_arry {
    
    public static void main(String[] args) {

        int[] arr = { 23, 2, 2, 3, 4, 5, 2, 1, 5, 45 };

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum = sum + arr[i];
        }
        
        System.out.println(sum);
    }
}