import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

    /**
     * Get a student by their seat number using the ArrayList.indexof method <br>
     * If the IndexOf method returns -1 then this method returns null otherwise, <br>
     * it return the student object associated with the seat number.
     * @param seat Student's seat number
     * @return If a student is found, it will reutrn the student object otherwise a null value
     * @throws Exception Creating a player with a invalid seat number could throw an error.
     */
    public Student getStudent(int seat) throws Exception {
        int index = this.allStudents.indexOf(new Student(seat));
        if (index == -1) {
            throw new Exception("Student not found.");
        }
        else
            return this.allStudents.get(index);

    }

    /**
     * Gets the student's amount of times the student was ontime to class and puts it in the arraylist.
     * @return Total times that student was on time
     */
    public int getOnTime() {
        int totalOnTime = 0;

        for (Student student : this.allStudents) {
            totalOnTime += student.getOnTime();
        }
        return totalOnTime;
    }


    /**
     * Gets the student's amount of times the student was late to class and puts it in the arraylist.
     * @return the amount of times the student was late.
     */
    public int getLate () {
        int late = 0;
        for (Student student : this.allStudents) {
            late += student.getLate();
        }
        return late;
    }

    /**
     * Adds a student to the list of all students, by using the overload constructor that allows setting
     * their name and seat number too.
     * This method will verify that the jersey number is not already used by another player by calling the
     * getStudent method, and if it is, then it will throw an exception back to the calling method.
     * @param seat Student's seat
     * @param name Student's name
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


    /**
     * Displays the report for each student's section, ontime, late, excused, and unexcused.
     */
    public void displaySummaryReport() {
        System.out.println("Section: " + this.getName() + " OnTime= " + this.getOnTime() + "Late= " + this.getLate() + "Excused= " + "Unexcused= ");
    }

    /**
     * Displays each student's seat number, number of ontime, lates, unexcused, and excused
     * by using the Student's getter methods
     */
    public void displayDetailReport() {
        Student student;

        displaySummaryReport();

        System.out.println("Seat Student         OnTime  Late  Unexcused  Excused");
        System.out.println("==== =======         ======  ====  =========  =======");

        for (Student value: allStudents) {

            student = value;

            System.out.printf("%6d %-15s %5d %3d %3d %3d %5d\n",
                    student.getLate(),
                    student.getExcused(),
                    student.getName(),
                    student.getSeat(),
                    student.getOnTime());
        }

        System.out.println();
    }

    /**
     * Converts student's name to a string
     * @return The student's name
     */
    @Override
    public String toString() {
        return this.name;
    }
}
