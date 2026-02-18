public class dectedcycle {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = arr.length;
        int m = 3; // Number of rotations

        // Rotate the array to the left by m positions
        rotateLeft(arr, m);

        // Print the rotated array
        System.out.println("Rotated Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void rotateLeft(int[] arr, int m) {
        int n = arr.length;
        m = m % n; // Handle cases where m is greater than n

        // Create a temporary array to hold the rotated elements
        int[] temp = new int[n];

        // Copy the elements from the original array to the temporary array
        for (int i = 0; i < n; i++) {
            temp[i] = arr[(i + m) % n];
        }

        // Copy the rotated elements back to the original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}