public class revest_array {
    
    public static void printt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        int[] arr = { 1, 3, 5, 6, 7, 8, 9, 12, 13, 15 };
        printt(arr);

        int i = 0;
        int j = arr.length-1;

        while (i < j) {

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;

        }
        printt(arr);
        
        
    }
}
