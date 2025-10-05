public class tow_elemtn_sum{
    
    public static void main(String[] args) {
        
        int[] arr = {12,21,38,69,74,83 };

        int x = 95;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[i] + arr[j + 1] == x) {
                    System.out.println(arr[i]);
                    System.out.println(arr[j+1]);

                }
            }
        }
    }
    
    
}
