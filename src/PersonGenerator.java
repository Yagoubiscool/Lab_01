import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {

        Scanner pipe = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        boolean done = false;

        while (!done) {

            String firstName =
                    SafeInput.getNonZeroLenString(pipe, "Enter first name");

            String lastName =
                    SafeInput.getNonZeroLenString(pipe, "Enter last name");

            String ID =
                    SafeInput.getNonZeroLenString(pipe, "Enter ID");

            String title =
                    SafeInput.getNonZeroLenString(pipe, "Enter title");

            int YOB =
                    SafeInput.getRangedInt(pipe,
                            "Enter year of birth",
                            1940,
                            2010);

            Person person =
                    new Person(firstName, lastName, ID, title, YOB);

            people.add(person);

            done = !SafeInput.getYNConfirm(pipe,
                    "Do you want to enter another person?");
        }

        try {
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("PersonData.csv"));

            for (Person person : people) {
                writer.write(person.toCSV());
                writer.newLine();
            }

            writer.close();

            System.out.println("Person data saved to PersonData.csv");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}