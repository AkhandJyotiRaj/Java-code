class Cricketer {
    // final String Coutnry = "India";
    static String Coutnry = "nothing";
    int runs;
    int over;
    double avg;
    
    // Cricketer(int runs, int over, double avg) {
    //     // this.Coutnry = Coutnry;
    //     this.runs = runs;
    //     this.over = over;
    //     this.avg = avg;
    // }
}

public class FinalandStatic {
    public static void main(String[] args) {
        
        
        
        Cricketer c1 = new Cricketer();
        // c1.Coutnry = "india";
        Cricketer c2 = new Cricketer();
        // c2.Coutnry = "bihar";
        System.out.println(c2.Coutnry);
    }
}
