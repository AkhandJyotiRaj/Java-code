public class practice {

    public static int find(int a[], int key) {
        int start  = 0 , end = a.length-1;

        
        while (start <= end){
                int mid = (start +end) / 2;
                if(key == a[mid]){
                    return mid;
                }
                if(key>a[mid]){
                    start =mid+1;
                }
                else{
                    end = mid - 1;
                }
        }
        
        return -1;
    }
    public static void main(String args[]) {
        int a[] = {2, 4, 5, 6, 7, 8, 9, 10,78,89,90 };
        int key = 9;
        System.out.print(find(a,key));
    }
}