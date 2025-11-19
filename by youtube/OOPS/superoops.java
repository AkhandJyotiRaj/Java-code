public class superoops {

    public static class students {
        String name;
        int classes;
        int marks;

        students() {
            
        }

        students(String name, int classes, int marks) {
            this.name = name;
            this.classes = classes;
            this.marks = marks;
        }
        
        public static class college extends students {
            int data;

            college() {
                
            }
            
            college(String name, int classes, int marks, int data) {
                super(name, classes, marks);
                this.data = data;

            }
        }
    }


    public static void main(String args[]) {
        students.college c1 = new students.college();
        c1.data = 2;
        System.out.println(c1.data);
    }
}
