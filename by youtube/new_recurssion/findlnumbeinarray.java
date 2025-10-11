public class findlnumbeinarray {
    

    public static boolean exists(int[] arr, int n,int idx) {
        if (idx == arr.length)
            return false;       
        
        if (arr[idx] == n)
            return true;
        return exists(arr, n, idx + 1);
    }


    public static void main(String[] args) {
        
        int arr[] = { 2, 3, 4, 5, 6, 8, 9 };

        int n = 4;

        System.out.println(exists(arr,n,0));
    }
}
