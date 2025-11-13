public class Linear_Search {

    public static boolean exist(int[] arr, int ele, int idx) {
        if (idx == arr.length)
            return false;
         if (arr[idx] == ele)
            return true;
        return exist(arr, ele, idx + 1);
    }
    
    public static void main(String[] args) {
        
        int[] arr = { 4, 6, 3, 6, 345, 4, 6, 6, 7, 60 };
        int ele = 9;

        System.out.println(exist(arr,ele,0));
    }
}
