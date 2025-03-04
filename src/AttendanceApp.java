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
        setupCourses();

        System.out.println();
        System.out.println(SINGLE_LINE);
        System.out.println();

        userInput = Input.getLine("Enter the 2nd course: ");
        section2.setName(userInput);
        setupCourses();
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
                seat = Input.getIntRange("Enter " + name + "'s seat number: ", 0, 30); .
                addStudent(name, seat);
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
        System.out.println("Game Started!");
        System.out.println(DOUBLE_LINE);
        System.out.println();


        while (playGame) {

            System.out.println(SINGLE_LINE);
            System.out.println("Main Menu");
            System.out.println(SINGLE_LINE);

            System.out.println("0 = End Game");
            System.out.println("1 = Enter " + section1.getName() + " Team's Stats");
            System.out.println("2 = Enter " + section2.getName() + " Team's Stats");
            System.out.println("3 = Display Game Stats");

            System.out.println(SINGLE_LINE);
            userInput = Input.getIntRange("Menu Choice: ", 0, 3);
            System.out.println(SINGLE_LINE);

            System.out.println();

            switch (userInput) {
                case 0:
                    playGame = false;
                    updatedAttendence();
                    System.out.println();
                    break;

                case 1:
                case 2:

                    if (userInput == 1)
                        updateTeamStats(section1);
                    else
                        updateTeamStats(section2);

                    System.out.println();
                    updatedAttendence();
                    System.out.println();
                    break;

                case 3:
                    displayGameStatus();
                    break;

                default:
                    System.out.println("Invalid menu choice = " + userInput);

            } // end of switch
        }

    } // end of playGame

    private void courseAttendence() {
        section1.displaySummaryReport();
        section2.displaySummaryReport();
    }
    private void studentAttendence() {
        section1.displayDetailReport();
        section2.displayDetailReport();
    }
    private void displayDetailReports() {

    }
    public static void main(String[] args) {

        AttendanceApp attend = new AttendanceApp();

        attend.displayDetailReports();

        try {
            attend.setupCourses();
            attend.setupStudents();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry but this program ended with an error. Please contact Jacob!");
        }

        Input.sc.close();
    }
}
