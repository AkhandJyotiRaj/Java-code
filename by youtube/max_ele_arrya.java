public class max_ele_arrya {
    
    public static void main(String[] args) {
        
        int[] arr = { 3, 5, 2, 5, 6, 1, 19, 2, 20 };
        
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

        }
        System.out.println(max);
    }
}
