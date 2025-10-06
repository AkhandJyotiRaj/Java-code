import java.util.*;
public class linearsrach {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array ");
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];


        System.out.println("enter all element " + n + " element");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                System.out.println(arr[i]);
                break;
            }
        }
        sc.close();
        
    }
}
