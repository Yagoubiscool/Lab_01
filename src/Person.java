import java.util.Calendar;
import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    /**
     * Constructs a Person with all fields.
     *
     * @param firstName the person's first name
     * @param lastName the person's last name
     * @param ID the person's ID
     * @param title the person's title
     * @param YOB the person's year of birth
     */
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the ID.
     *
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the year of birth.
     *
     * @return the year of birth
     */
    public int getYOB() {
        return YOB;
    }

    /**
     * Sets the year of birth.
     *
     * @param YOB the new year of birth
     */
    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    /**
     * Returns the person's full name.
     *
     * @return first name and last name
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns the person's formal name.
     *
     * @return title and full name
     */
    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * Returns the person's age using the current year.
     *
     * @return the person's age
     */
    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear - YOB);
    }

    /**
     * Returns the person's age for a specified year.
     *
     * @param year the specified year
     * @return the person's age
     */
    public String getAge(int year) {
        return String.valueOf(year - YOB);
    }

    /**
     * Converts the Person to CSV format.
     *
     * @return CSV string
     */
    public String toCSV() {
        return firstName + "," + lastName + "," + ID + "," + title + "," + YOB;
    }

    /**
     * Converts the Person to JSON format.
     *
     * @return JSON string
     */
    public String toJSON() {
        return "{\"firstName\":\"" + firstName +
                "\",\"lastName\":\"" + lastName +
                "\",\"ID\":\"" + ID +
                "\",\"title\":\"" + title +
                "\",\"YOB\":" + YOB + "}";
    }

    /**
     * Converts the Person to XML format.
     *
     * @return XML string
     */
    public String toXML() {
        return "<Person>" +
                "<firstName>" + firstName + "</firstName>" +
                "<lastName>" + lastName + "</lastName>" +
                "<ID>" + ID + "</ID>" +
                "<title>" + title + "</title>" +
                "<YOB>" + YOB + "</YOB>" +
                "</Person>";
    }

    /**
     * Returns the Person as a string.
     *
     * @return Person information
     */
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    /**
     * Compares this Person to another object.
     *
     * @param obj the object to compare
     * @return true if the Person objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person person = (Person) obj;

        return YOB == person.YOB &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(ID, person.ID) &&
                Objects.equals(title, person.title);
    }
}