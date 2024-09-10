import java.util.*;

public class largest {
    public static int largestnumber(int num[])
    {
        int large= Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            if (large < num[i]) {
                large = num[i];
            }
        }
        return large;
    }
    public static void main(String args[]) {
        int num[] = {1,4,2,4,5,3,5,3,5,9,4,4,4};
         
        System.out.print("Lergest in this array : " + largestnumber(num));
    }
}
