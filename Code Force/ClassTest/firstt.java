import java.util.*;
public class firstt {
    

    public static List<String> generatestring(int n) {
        List<String> result = new ArrayList<>();
        callingg("", n, result);
        return result;
    }

    public static void callingg(String current, int n, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        callingg(current + "L",n, result);
        callingg(current + "H", n, result);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numbers of slots : ");
        int n = sc.nextInt();

        List<String> finall = generatestring(n);

        System.out.println("All single configuratataions ");
        for (String s : finall) {
            System.out.print(s+ " ");
        }
    }
}