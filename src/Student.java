/**
 * The Student class represents a student with a seat number, name, and attendance records.
 * It provides methods to manage and track student attendance.
 */
public class Student {
    private int seat;
    private String name;
    private int onTime;
    private int late;
    private int excused;
    private int unexcused;

    /**
     * Private default constructor that initializes default values.
     */
    private Student() {
        this.seat = 0;
        this.name = "Unknown";
        this.onTime = 0;
        this.late = 0;
        this.excused = 0;
        this.unexcused = 0;
    }

    /**
     * Constructs a Student with a specified seat number.
     * @param seat The seat number of the student.
     * @throws Exception If the seat number is invalid.
     */
    public Student(int seat) throws Exception {
        this(); // Calls the private default constructor
        setSeat(seat);
    }

    /**
     * Constructs a Student with a specified seat number and name.
     * @param seat The seat number of the student.
     * @param name The name of the student.
     * @throws Exception If the seat number or name is invalid.
     */
    public Student(int seat, String name) throws Exception {
        this(); // Calls the private default constructor
        setSeat(seat);
        setName(name);
    }

    /**
     * Gets the seat number of the student.
     * @return The seat number.
     */
    public int getSeat() {
        return seat;
    }

    /**
     * Gets the name of the student.
     * @return The student name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of times the student was on time.
     * @return The on-time count.
     */
    public int getOnTime() {
        return onTime;
    }

    /**
     * Gets the number of times the student was late.
     * @return The late count.
     */
    public int getLate() {
        return late;
    }

    /**
     * Gets the number of excused absences.
     * @return The excused absence count.
     */
    public int getExcused() {
        return excused;
    }

    /**
     * Gets the number of unexcused absences.
     * @return The unexcused absence count.
     */
    public int getUnexcused() {
        return unexcused;
    }

    /**
     * Sets the seat number of the student.
     * @param seat The new seat number.
     * @throws Exception If the seat number is invalid.
     */
    public void setSeat(int seat) throws Exception {
        if (seat < 1) {
            throw new Exception("Seat number must be positive.");
        }
        this.seat = seat;
    }

    /**
     * Sets the name of the student.
     * @param name The new name.
     * @throws Exception If the name is null or empty.
     */
    public void setName(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Name cannot be empty.");
        }
        this.name = name;
    }

    /**
     * Updates the student's attendance record based on the given status.
     * @param status The attendance type (1=On Time, 2=Late, 3=Excused, 4=Unexcused).
     * @throws Exception If an invalid attendance type is received.
     */
    public void updateAttendance(int status) throws Exception {
        switch (status) {
            case 1:
                onTime++;
                break;
            case 2:
                late++;
                break;
            case 3:
                excused++;
                break;
            case 4:
                unexcused++;
                break;
            default:
                throw new Exception("Invalid attendance type. Use 1-4.");
        }
    }

    /**
     * Returns a formatted string representation of the student's attendance record.
     * @return A string showing the attendance details.
     */
    public String getAttendanceRecord() {
        return "Seat#" + seat + " " + name + " (On Time=" + onTime + ", Late=" + late + ", Excused=" + excused + ", Unexcused=" + unexcused + ")";
    }

    /**
     * Compares this student with another object to check if they have the same seat.
     * @param obj The object to compare.
     * @return True if the students have the same seat, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return seat == student.seat;
    }

    /**
     * Returns a string representation of the student, displaying seat number and name.
     * @return A formatted string with seat number and name.
     */
    @Override
    public String toString() {
        return seat + " " + name;
    }
}
