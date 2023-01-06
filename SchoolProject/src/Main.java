import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        //creates the school object called "Lord Byng"
        School lordByng = new School("Lord Byng","16th & Crown St","(604) 713-8171");

        //creates the 3 teachers
        System.out.println("Create 3 teachers: ");
        Teacher x = new Teacher("John", "Smith", "Science");
        Teacher y = new Teacher("Sam", "Davis", "Math");
        Teacher z = new Teacher("Mary", "jones", "Art");
        lordByng.addTeacher(x);
        lordByng.addTeacher(y);
        lordByng.addTeacher(z);

        lordByng.showAllTeachers();
        System.out.println("");

        //creates the 10 students
        System.out.println("Create 10 students: ");
        Student a = new Student("Ben", "Bobby", 10);
        Student b = new Student("Joe", "Joey", 11);
        Student c = new Student("Charles", "Chang", 9);
        Student d = new Student("Rob", "Robbie", 12);
        Student e = new Student("Hanson", "Hanes", 8);
        Student f = new Student("Zach", "Afton", 9);
        Student g = new Student("Harry", "Hank", 10);
        Student h = new Student("Ethan", "Ethans", 8);
        Student i = new Student("Jason", "James", 8);
        Student j = new Student("Andrew", "Marcels", 12);
        lordByng.addStudent(a);
        lordByng.addStudent(b);
        lordByng.addStudent(c);
        lordByng.addStudent(d);
        lordByng.addStudent(e);
        lordByng.addStudent(f);
        lordByng.addStudent(g);
        lordByng.addStudent(h);
        lordByng.addStudent(i);
        lordByng.addStudent(j);
        lordByng.showAllStudents();
        System.out.println("");

        //prints the remaining teachers
        System.out.println("Delete Teacher at Index 1");
        Teacher deletedTeacher = lordByng.deleteTeacher(1);
        System.out.println("Deleted Teacher " + deletedTeacher.toString());
        System.out.println("Show remaining teachers: ");
        lordByng.showAllTeachers();
        System.out.println("");

        //prints out the remaining students
        System.out.println("Delete Student at Index 0 & 1");
        Student deletedStudent1 = lordByng.deleteStudent(0);
        Student deletedStudent2 = lordByng.deleteStudent(1);
        System.out.println("Deleted Student " + deletedStudent1.toString());
        System.out.println("Deleted Student " + deletedStudent2.toString());
        System.out.println("list of remaining students: ");
        lordByng.deleteStudent(0);
        lordByng.deleteStudent(1);
        lordByng.showAllStudents();


    }
}
