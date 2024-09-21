public class linearsearch {
    
    public static int linear(int number[], int key) {
        
        for (int i = 0; i < number.length; i++) {
            if (number[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        int number[] = { 1, 4, 2, 4, 3, 4, 5, 5, 3, 4, 4,4,10 };
        int key = 11;

        int index = linear(number, key);
        if (index == -1) {
            System.out.print("System not found");
        }
        else { 
            System.out.print(index);
        }
    }
}