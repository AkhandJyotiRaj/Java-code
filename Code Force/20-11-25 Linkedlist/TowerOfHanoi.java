public class TowerOfHanoi {

    public static void solve(int n, char fromRod, char toRod, char auxRod) {
        // Base case
        if (n == 1) {
            System.out.println("Move disk 1 from " + fromRod + " to " + toRod);
            return;
        }

        // Move top n-1 disks from source to auxiliary
        solve(n - 1, fromRod, auxRod, toRod);

        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);

        // Move the n-1 disks from auxiliary to destination
        solve(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        int n = 2;  // number of disks
        solve(n, 'A', 'C', 'B');  // A = source, C = destination, B = auxiliary
    }
}
