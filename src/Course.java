import java.util.ArrayList;
import java.util.List;

/**
 * Use to keep track of a teacher's class that is made up with multiple students with assigned seats along
 * with each student's section, ontime, late, excused, unexcused.
 * @author jascha10, thebottleopener
 * @since 2/26/2025
 * @version 1.0 beta
 * @see <a href="https://github.com/jascha10/AttendenceAppProject>Github Repository</a>
 */
public class Course {

    /**
    Gets course's name
     */
    private String name;

    /**
    Creates a list that stores all the students
     */
    private List<Student> allStudents;

    /**
    Sets the course name to "Unknown" and creates an empty allStudent ArrayList.
     */
    public Course() {
        name = "Unknown";
        allStudents = new ArrayList<>();

    }

    /**
     * Gets the name of the class
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Calls the default contsructor, and then set's the name using the setter for data validation
     * @param name the course name
     * @throws Exception if setName fails due to a blank name
     */
    public void setName(String name) throws Exception {
        name = name.trim();

        if (name.isBlank()) {
            throw new Exception("Course name can not be blank.");
        }

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
