public class Student {
    private int seat;
    private String name;

    public Student(int seat, String name) {
        this.seat = seat;
        this.name = name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    /**
     * Set the Player's name. Uses the trim method to remove leading and trailing spaces
     * and then if the name is an empty string, it will throw an error
     * if not then it will set the player's name.
     * @param name The Player's name
     * @throw Exception if the player's name is blank (whitespace or empty)<br>
     * Error Example: Name cannot be blank for jersey number #10!
     */
    public void setName(String name) throws Exception {

        name = name.trim();

        if ( name.isBlank())
            throw new Exception();
        else
            this.name = name;
    } // end of setName method

    @Override
    public String toString() {
        return seat + " " + name;
    }

}
