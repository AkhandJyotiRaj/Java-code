public class Pallidrom {
    
    public static void pali(int[] arr) {
        
        int st = 0;
        int end = arr.length - 1;

        while (st > end) {
            if (arr[st] == arr[end]) {
                st++;
                end--;
            }      
            
        }
        
    }

    public static void main(String[] args) {
        
        int[] arr = { 1, 2, 1 };
        pali(arr);
    }
}
