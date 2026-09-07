import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SafeInputObjTest {

    @Test
    void getNonZeroLenString() {
        Scanner scanner = new Scanner("John\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertEquals("John", input.getNonZeroLenString("Enter name"));
    }

    @Test
    void getRangedInt() {
        Scanner scanner = new Scanner("5\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertEquals(5, input.getRangedInt("Enter number", 1, 10));
    }

    @Test
    void getInt() {
        Scanner scanner = new Scanner("25\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertEquals(25, input.getInt("Enter age"));
    }

    @Test
    void getRangedDouble() {
        Scanner scanner = new Scanner("4.5\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertEquals(4.5, input.getRangedDouble("Enter rating", 1, 5));
    }

    @Test
    void getDouble() {
        Scanner scanner = new Scanner("19.99\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertEquals(19.99, input.getDouble("Enter price"));
    }

    @Test
    void getYNConfirm() {
        Scanner scanner = new Scanner("Y\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertTrue(input.getYNConfirm("Continue?"));
    }

    @Test
    void getRegExString() {
        Scanner scanner = new Scanner("45150\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertEquals("45150",
                input.getRegExString("Enter ZIP code", "\\d{5}"));
    }
}