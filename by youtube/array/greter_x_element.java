public class greter_x_element {
    
    public static void main(String[] args) {
        
        int[] arr = { 3, 35, 3, 2, 5, 34, 53, 23 };
        int x = 3;

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) {
                count++;
            }
        }
        System.out.println(count);

    }
}
