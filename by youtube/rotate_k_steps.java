public class rotate_k_steps {
    
    public static void printt(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.err.println();
    }

    public static void rotate(int[] arr, int i,int j) {
        
        System.out.println(j);
        while (i < j) {

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        System.out.println(j);
        
    }

    public static void main(String[] args) {
        
        
        int[] arr = { 2, 4, 6, 8, 9, 10, 11, 12, 13 };
        int k = 5;
        int i = 0;
        int j = arr.length - 1;
        printt(arr);


        rotate(arr, 0, j);

        printt(arr);

        rotate(arr, i, j - k);
        
        printt(arr);
        
        
        
        rotate(arr, j-k+1, j);
        


        printt(arr);
        
    }
}
