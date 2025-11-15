class Student {
    String name;
    private int rollno = 4;
    double cpga;

    int getrollno() {  // Getter
        return rollno;
    }

    void setrollno(int x) {  // Setter
        rollno = x;
    }
}

public class PrivateandPublic {

   

    public static void main(String[] args) {
        
        Student s1 = new Student();
        s1.name = "rahul:";

        System.out.println(s1.getrollno());

        s1.setrollno(10);
        System.out.println(s1.getrollno());


    }
}
