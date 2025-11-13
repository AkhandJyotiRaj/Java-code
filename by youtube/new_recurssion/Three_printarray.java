public class Three_printarray {
    
    public static void main(String[] args) {

        int[] arr = { 4, 6, 3, 6, 345, 4, 6, 6, 7, 60 };
        printt(arr, 0);
    }
    
    public static int printt(int[] arr, int idx) {
        int n = arr.length;
        if (idx == n)
            return -1;
        
        System.out.print(arr[idx]+" ");
        return printt(arr, idx + 1);
    }
}
