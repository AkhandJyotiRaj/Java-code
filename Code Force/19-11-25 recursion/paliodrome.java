import java.util.*;

public class paliodrome {
    pubilc static v

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = { 1, 2, 3, 2, 1 };

        pali(arr);
        
    }
}





// import java.util.Scanner;

// public class PalindromeArray {

//     // Recursive method
//     public static boolean isPalindrome(int[] arr, int left, int right) {
//         if (left >= right) return true;           // base case
//         if (arr[left] != arr[right]) return false;
//         return isPalindrome(arr, left + 1, right - 1);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         // Read array size
//         System.out.print("Enter size of array: ");
//         int n = sc.nextInt();

//         int[] arr = new int[n];

//         // Read array elements
//         System.out.println("Enter " + n + " elements:");
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         // Check palindrome
//         if (isPalindrome(arr, 0, arr.length - 1)) {
//             System.out.println("yes");
//         } else {
//             System.out.println("no");
//         }

//         sc.close();
//     }
// }
