public class AttendanceApp {

    /**
     * Section 1 course
     */
    private final Course section1;

    /**
     * Section 2 course
     */
    private final Course section2;

    /**
     * Used to display a double dash line
     */
    private final static String DOUBLE_LINE = "=========================================";

    /**
     * Used to display a single dash line.
     */
    private final static String SINGLE_LINE = "-----------------------------------------";

    /**
     * Default Constructor that instantiate 2 courses.
     */
    public AttendanceApp() {
        section1 = new Course();
        section2 = new Course();
    }

    /**
     *  Displays the AttendanceApp header. Example:<br>
     *  <pre>
     *  =========================================
     *  Welcome to the Attendance App
     *  =========================================
     *  </pre>
     */
    private void displayAppHeading() {
        System.out.println(DOUBLE_LINE);
        System.out.println("Welcome to the Attendance App");
        System.out.println(DOUBLE_LINE);
        System.out.println();
    }

    private void setupCourses() throws Exception {
        String userInput;

        userInput = Input.getLine("Enter the course 1: ");
        section1.setName(userInput);

        System.out.println();
        System.out.println(SINGLE_LINE);
        System.out.println();

        userInput = Input.getLine("Enter the 2nd course: ");
        section2.setName(userInput);
    }

    private void setupStudents(Course course) {
        String courseName = course.getName();
        String name;
        int seat;

        while (true) {
            System.out.println();
            name = Input.getLine("Enter " + courseName + " student's name or 'q' to quit: ");

            if (name.equals("q"))
                return;

            try {
                seat = Input.getIntRange("Enter " + name + "'s seat number: ", 0, 30);
                course.addStudent(seat, name);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Unable to add student!");
            }

        }

    } // end of setupPlayers
    private void mainMenu() throws Exception {

        boolean playGame = true;
        int userInput;

        System.out.println();
        System.out.println(DOUBLE_LINE);
        System.out.println("Attendance App");
        System.out.println(DOUBLE_LINE);
        System.out.println();


        while (playGame) {

            System.out.println(SINGLE_LINE);
            System.out.println("Main Menu");
            System.out.println(SINGLE_LINE);

            System.out.println("0 = End Game");
            System.out.println("1 = Enter " + section1.getName() + " Attendance Stats");
            System.out.println("2 = Enter " + section2.getName() + " Attendance Stats");
            System.out.println("3 = Display all Attendence Stats");

            System.out.println(SINGLE_LINE);
            userInput = Input.getIntRange("Menu Choice: ", 0, 3);
            System.out.println(SINGLE_LINE);

            System.out.println();

            switch (userInput) {
                case 0:
                    playGame = false;
                    courseAttendence(section1);
                    System.out.println();
                    break;

                case 1:
                case 2:

                    if (userInput == 1)
                        courseAttendence(section1);
                    else
                        courseAttendence(section2);

                    System.out.println();
                    courseAttendence(section1);
                    System.out.println();
                    break;

                case 3:
                    displayAppHeading();
                    break;

                default:
                    System.out.println("Invalid menu choice = " + userInput);

            } // end of switch
        }

    }// end of playGame

    private void updateCourseStats(Course course) throws Exception {

        int seat;
        Student student;

        while (true) {
            seat = Input.getIntRange("Enter " + course.getName() + "'s Jersey # ", 1, 55);

            student = course.getStudent(seat);

            if (student == null) {
                System.out.println("Invalid #, please try again!");
                continue;
            }

            course.addStudent(seat, student.getName());

            break;
        }

        System.out.println();
        System.out.println(SINGLE_LINE);

    } // end of updateTeam

    private void updateStudentStats(Course course) {
        int type;
        Student student = null;

        System.out.println();

        System.out.println(SINGLE_LINE);
        System.out.println("Enter " + student.getSeat() + " " + student.getName() + " attendance information");
        System.out.println(SINGLE_LINE);

        System.out.println("0 = End Attendance App");
        System.out.println("1 = Take 9:00 am Attendance");
        System.out.println("2 = Take 10:00 am Attendance");
        System.out.println("3 = Display All Attendance Report");

        System.out.println(SINGLE_LINE);
        type = Input.getIntRange("Menu Choice: ", 0, 3);
        System.out.println(SINGLE_LINE);

        try {
            student.updateAttendance(type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to update students!");
        }

        student.displayAttendance();

    }


    private void courseAttendence(Course section) throws Exception {
        this.section1.displaySummaryReport();
        this.section2.displaySummaryReport();
    }
    private void studentAttendence(Course section) throws Exception {
        this.section1.displayDetailReport();
        this.section2.displayDetailReport();
    }
    private void displayDetailReports() {

    }
    public static void main(String[] args) {

        AttendanceApp attend = new AttendanceApp();

        attend.displayDetailReports();

        try {
            attend.setupCourses();
            attend.mainMenu();
            attend.studentAttendence(attend.section1);
            attend.studentAttendence(attend.section2);
            attend.setupStudents(attend.section1);
            attend.setupStudents(attend.section2);
            attend.updateCourseStats(attend.section1);
            attend.updateCourseStats(attend.section2);
            attend.updateStudentStats(attend.section1);
            attend.updateStudentStats(attend.section2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry but this program ended with an error. Please contact Jacob!");
        }

        Input.sc.close();
    }
}
