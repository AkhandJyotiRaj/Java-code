public class reverse {
    

    public static int rev(int numbers[]) {
        int start = 0 , end = numbers.length-1;
        while (start < end) {

            int temp = numbers[end];
            numbers[end] = numbers[start];
            numbers[start] = temp;
            start++;
            end--;
        }
        return -1;
    }
    public static void main(String args[]) {
        int numbers[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        rev(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+ " ");
        }


    }
}
