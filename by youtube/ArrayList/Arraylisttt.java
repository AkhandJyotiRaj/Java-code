import java.util.*;

public class Arraylisttt {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> l1 = new ArrayList<>();

        l1.add(5);
        l1.add(4);
        l1.add(5);
        l1.add(2, 2);

        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }

    }
}