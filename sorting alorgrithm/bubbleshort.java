public class bubbleshort {

    public static void bubbleShort(int arr[]){
        
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){

                if(arr[j+1]<arr[j]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = { 4, 3, 5, 2, 1 };
        bubbleShort(arr);
        printarr(arr);
    }
}
