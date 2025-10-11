    public class aray {

        public static int printt(int[] arr, int n) {
            if (n == arr.length)
                return 0;
            System.out.print(arr[n] +" ");

            return printt(arr, n + 1);
        }
        
        public static void main(String[] args) {
            
            int[] arr = { 2, 3, 4, 5, 6, 6, 4 };
            printt(arr, 0) ;
        }
    }
