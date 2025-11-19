import java.util.Scanner;

public class numberOfWays {

    public static int countWays(int current, int end) {
        if (current == end) return 1;     // valid path
        if (current > end) return 0;      // invalid path

        // Recursive sum for 1, 2, and 3 steps
        return countWays(current + 1, end)
             + countWays(current + 2, end)
             + countWays(current + 3, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int E = sc.nextInt();

        System.out.println(countWays(S, E));
    }
}
