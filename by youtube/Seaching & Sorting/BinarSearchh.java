
public class BinarSearchh {
    
    public static void serachh(int[] arr, int target) {
        
        int st = 0;
        int end = arr.length - 1;

        while (st <= end) {
            int mid = (st + end) / 2;

            if (target == arr[mid]) {
                System.out.println("find  index " + mid);
                break;
            } else if (target < arr[mid]) {
                end = mid - 1;
            }
            else
                st = mid + 1;
        }
            
        }

    public static void main(String[] args) {
        
        int[] arr = { 2, 4, 6, 8, 9, 10 ,11};
        serachh(arr,10);

    }
}
