public class binarysearch {
    

    public static int binary(int numbers[], int key) {
        int start = 0, end = numbers.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (numbers[mid] == key) {
                return mid;
            }
            if (numbers[mid] < key) {
                start = mid + 1;
            } else {
                end = mid = 1;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        int numbers[] = { 45, 2, 3, 2, 2321, 45, 45, 324, 25, 43,45 };
        int key = 45;
        System.out.println("key = : " + binary(numbers,key));

    }
}
