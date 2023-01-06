public class Teacher { //teacher class

    //private fields for the teacher class
    private String firstName;
    private String lastName;
    private String subject;

    // Teacher Constructor with parameters
    public Teacher(String firstName, String lastName, String subject ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;

    }

    //teacher default constructor
    public Teacher (){
        this("","","");

    }

    // Getters and Setters
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
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    //converts all the fields into a single string that represents a teacher
    public String toString(){
        String string = "Name: " + firstName + " " + lastName + " Subject: " + subject;
        return string;
    }
}
