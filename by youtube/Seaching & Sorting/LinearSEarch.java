
public class LinearSEarch {

    public static int serach(int[] arr, int target, int idx) {

        if (idx == arr.length) {
            return -1;
        }
        if (arr[idx] == target)
            return idx;

        return serach(arr, target, idx + 1);
    }   
    

    public static void main(String[] args) {
        
        int[] arr = { 2, 4, 5, 6, 7, 8, 9 };
        int target = 1;
        int result = serach(arr, target, 0);
        if (result == -1)
            System.out.println("not found");
        else System.out.println("found" + result);

        // System.out.println(serach(arr, target,0));

    }
}
