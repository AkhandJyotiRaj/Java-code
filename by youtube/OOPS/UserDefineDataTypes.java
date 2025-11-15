class UserDefineDataTypes {

    public static class Student {
        String name;
        int rno;
        double cgpa;

        void print() {
            System.out.println(name + " " + rno+ " " + cgpa+" ") ;
        }
    }

    
    
    public static void main(String[] args) {
        
        Student S1 = new Student();   // Objects
        S1.name = "Suprime randi";
        S1.rno = 45;
        S1.cgpa = 9;
        
        Student S2 = new Student();
        S2.name = "Akhandi jyoti";
        S2.rno = 1420057;
        S2.cgpa = 5.8;

        Student S3 = new Student();
        S3.name = "Anagha";
        S3.rno = 13;
        S3.cgpa = 9.37;

        System.out.println(S1.name); // Print for
        S1.print();
        S2.print();
        S3.print();
    }
}