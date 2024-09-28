public class pair {

    public static void pairr(int a[]) {
        
        for (int i = 0; i < a.length; i++) {
            int start = a[i];
            for (int j = i + 1; j < a.length; j++) {
                System.out.print("( " + start + "," + a[j] + " )");
            }
            System.out.println();
        }
        
    }


    public static void main(String args[]) {
        int a[] = { 2, 4, 6, 8, 19 };
        pairr(a);
    }
}
