public class uniquepath {

    public static int uniquepath(int a, int b) {
        if (a == 1 || b == 1)
            return 1;
        return uniquepath(a - 1, b) + uniquepath(a, b - 1);
    }
    public static void main(String[] args) {
        System.out.println(uniquepath(3, 3));
    }
    
}
