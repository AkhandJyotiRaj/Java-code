public class revesrofgivennumber {
    
    public static int ultaprint(int n, int x){

        if(n ==0){
            return x;
        }
        
        int lastdigit = n%10;
        x = x*10 + lastdigit;
        return ultaprint(n/10,x);
    }

    public static void main(String[] args) {
        
        int n = 3456;

        ultaprint(n, 0);

    }
}