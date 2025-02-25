// import java.util.Scanner;

// public class forpractice {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         // Input the size of the array
//         System.out.print("Enter the size of the array: ");
//         int size = scanner.nextInt();

//         // Create an array of the specified size
//         int array[] = new int[size];

//         // Input elements into the array
//         System.out.println("Enter " + size + " integers:");
//         for (int i = 0; i < size; i++) {
//             array[i] = scanner.nextInt();
//         }

//         // Display the array
//         System.out.println("You entered the following array:");
//         for (int i = 0; i < size; i++) {
//             System.out.print(array[i] + " ");
//         }

//         // Close the scanner
//         scanner.close();
//     }
// }

// import java.util.*;

// public class forpractice {
//     public static void main(String args[]) {
        
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter size of array : ");
//         int size = sc.nextInt();

//         System.out.println("enter " + size + " array");
//         int array[] = new int[size];

//         for (int i = 0; i < size; i++) {
//             array[i] = sc.nextInt();
//         }
//         System.out.print("[ ");
//         for (int i = 0; i < size; i++) {
//             System.out.print(array[i] + " ");
//         }
//         System.out.print("]");

//     }
// }

public class forpractice {
    public static void main(String[] args) {
        // Define a sample 2D array
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 4, 5, 6, 4 },
                { 7, 8, 9, 4 }
        };

        // Display the matrix
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print(matrix[0].length);

        // Print Column-major order
        System.out.println("\nColumn-major order:");
        columnMajorOrder(matrix);
    }

    // Method to print Column-major order
    public static void columnMajorOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Traverse through each column and then each row within the column
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }
}



