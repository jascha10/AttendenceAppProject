import java.util.ArrayList;
import java.util.List;

public class Course {

    /*
    Gets course's name
     */
    private String name;

    /*
    Creates a list that stores all the students
     */
    private List<Student> allStudents;

    /*
    Sets the course name to unkown and creates an empty allStudent ArrayList.
     */
    public Course() {
        name = "Unknown";
        allStudents = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        this.name = name;
    }

    public Student getStudent(int seat) throws Exception {
        this.allStudents.get(seat);
        return null;
    }

    /**
     * Adds a student to the list of all students, by using the overload constructor that allows setting
     * their name and seat number too.
     * This method will verify that the jersey number is not already used by another player by calling the
     * getStudent method, and if it is, then it will throw an exception back to the calling method.
     * @param seat
     * @param name
     * @throws Exception
     */
    public void addStudent(int seat, String name) throws Exception {
        Student student = this.getStudent(seat);
        if(student == null) {
            this.allStudents.add(new Student(seat, name));
        } else {
            throw new Exception("Seat #: " + seat + " already assigned to " + student.getName() + "!");
        }
    }



    public void displaySummaryReport() {
        System.out.println("Section: " + this.getName() + " OnTime= "  + "Late= " + "Excused= " + "Unexcused= ");
    }
}
