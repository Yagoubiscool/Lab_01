import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PersonReader {

    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();

        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader("PersonData.csv"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] fields = line.split(",");

                String firstName = fields[0];
                String lastName = fields[1];
                String ID = fields[2];
                String title = fields[3];
                int YOB = Integer.parseInt(fields[4]);

                Person person =
                        new Person(firstName, lastName, ID, title, YOB);

                people.add(person);
            }

            reader.close();

            System.out.println("Person data read from PersonData.csv");
            System.out.println();

            for (Person person : people) {
                System.out.println(person);
            }

        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }
}