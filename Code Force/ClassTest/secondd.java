import java.util.*;

public class secondd {

    public static List<String> generateNew(int n)
    {
        List<String> result = new ArrayList<>();
        callingg("", n, result);
        return result;
    }

    public static void callingg(String current, int n, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        callingg(current + "H", n, result);
        if (current.isEmpty() || current.charAt(current.length() - 1) != 'L') {
            callingg(current + "L", n, result);
        }
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print( "Enter number here : ");
        int n = sc.nextInt();

        List<String> finall = generateNew(n);
        System.out.println("Here the input here");
        for (String s : finall) {
            System.out.print(s+" ");
        }

        
    }
}
