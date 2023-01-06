import java.util.ArrayList;

public class School { //school class
    private ArrayList<Teacher> teachers = new ArrayList<>(); // creates array list for teachers
    private ArrayList<Student> students = new ArrayList<>(); //creates array list for students
    //this existed in the starter file ,but it is never used
    private ArrayList<String> courses  = new ArrayList<>(); //creates array list for courses

    //private fields for the school class
    private String schoolName;
    private String address;
    private String phoneNumber;

    //school constructor
    public School(){
        schoolName = "";
        address = "";
        phoneNumber = "";
    }

    //school constructor with parameters
    public School(String schoolName, String address, String phoneNumber){
        this.schoolName = schoolName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    //getters and setters
    public String getSchoolName () {
        return schoolName;
    }

    public void setSchoolName (String schoolName){
        this.schoolName = schoolName;
    }


    public String getAddress () {
        return address;
    }
    public void setAddress (String address){
        this.address = address;
    }


    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }



    //shows all students
    public void showAllStudents(){
        for( int i = 0; i < students.size(); i ++){
            Student s = students.get(i);
            System.out.println(s);

        }
    }
    //Add new student to current Student arraylist
    public void addStudent (Student student){
        students.add(student);
    }

    //prints out all the teachers
    public void showAllTeachers(){
        for (int i = 0; i < teachers.size(); i ++){
            Teacher s = teachers.get(i);
            System.out.println(s);
        }
    }

    //method for adding teacher to teacher arraylist
    public void addTeacher (Teacher teacher){
        teachers.add(teacher);
    }

    //method for deleting student at index from students arraylist
    //return the student that was deleted
    public Student deleteStudent(int index){
        if( 0 <= index && index < students.size()){
          return students.remove(index);
        }
        else {
            return null;
        }

    }

    //method for deleting teacher at index from teachers arraylist
    //return the teacher that was removed
    public Teacher deleteTeacher(int index){
        if (0<= index && index < teachers.size()){
            return teachers.remove(index);
        }
        else {
            return null;
        }
    }



}
