public class Student { //student class

    // private fields for student class
    private String firstName;
    private String lastName;
    private int grade;
    private int studentNumber;
    //used to generate the next student ID for all students created
    private static int studentNumberGenerator;
    
    // student constructor with fields
    public Student (String firstName, String lastName, int grade ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.studentNumber = ++studentNumberGenerator;
    }

    //student default constructor
    public Student(){
        this("","",0);
    }

    //getters and setters
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public int getGrade(){
        return grade;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }
    public int getStudentNumber(){
        return studentNumber;
    }

    //converts all the fields into one string that represents a student
    public String toString() {
        String string = "Name: " + firstName + " " + lastName + " Grade: " + grade + " Student Number: " + studentNumber;
        return string;
    }

}
