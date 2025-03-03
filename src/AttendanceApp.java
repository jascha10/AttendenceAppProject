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

    public AttendanceApp() {
        section1 = new Course();
        section2 = new Course();
    }
}
