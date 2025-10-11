    public class aray {

        public static void printt(int[] arr, int n) {
            if (n == arr.length)
                return;
            

           printt(arr, n + 1);

            System.out.print(arr[n] +" ");
        }
        
        public static void main(String[] args) {
            
            int[] arr = { 2, 3, 4, 5, 6, 6, 4 };
            printt(arr, 0) ;
        }
    }
