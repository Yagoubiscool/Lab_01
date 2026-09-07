import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;

    @BeforeEach
    void setUp() {
        person = new Person("John", "Doe", "123456", "Mr.", 2000);
    }

    @Test
    void constructorTest() {
        Person testPerson = new Person("Jane", "Smith", "654321", "Ms.", 1999);

        assertEquals("Jane", testPerson.getFirstName());
        assertEquals("Smith", testPerson.getLastName());
        assertEquals("654321", testPerson.getID());
        assertEquals("Ms.", testPerson.getTitle());
        assertEquals(1999, testPerson.getYOB());
    }

    @Test
    void setFirstName() {
        person.setFirstName("James");
        assertEquals("James", person.getFirstName());
    }

    @Test
    void setLastName() {
        person.setLastName("Smith");
        assertEquals("Smith", person.getLastName());
    }

    @Test
    void setTitle() {
        person.setTitle("Dr.");
        assertEquals("Dr.", person.getTitle());
    }

    @Test
    void setYOB() {
        person.setYOB(1995);
        assertEquals(1995, person.getYOB());
    }

    @Test
    void fullName() {
        assertEquals("John Doe", person.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Mr. John Doe", person.formalName());
    }

    @Test
    void getAge() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        assertEquals(String.valueOf(currentYear - 2000), person.getAge());
    }

    @Test
    void getAgeForYear() {
        assertEquals("25", person.getAge(2025));
    }

    @Test
    void toCSV() {
        assertEquals("John,Doe,123456,Mr.,2000", person.toCSV());
    }

    @Test
    void toJSON() {
        assertEquals(
                "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"ID\":\"123456\",\"title\":\"Mr.\",\"YOB\":2000}",
                person.toJSON()
        );
    }

    @Test
    void toXML() {
        assertEquals(
                "<Person><firstName>John</firstName><lastName>Doe</lastName><ID>123456</ID><title>Mr.</title><YOB>2000</YOB></Person>",
                person.toXML()
        );
    }

    @Test
    void testToString() {
        assertEquals(
                "Person{firstName='John', lastName='Doe', ID='123456', title='Mr.', YOB=2000}",
                person.toString()
        );
    }

    @Test
    void testEquals() {
        Person samePerson = new Person("John", "Doe", "123456", "Mr.", 2000);
        assertEquals(person, samePerson);
    }
}