public class second_largest {
    
    public static void main(String[] args) {
        
        int[] arr = { 3, 5, 2, 5, 6, 1, 19, 2, 20 };
        
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >smax && arr[i] != max) {
                smax = arr[i];
            }
        }
        System.out.println(smax);
    }
}
