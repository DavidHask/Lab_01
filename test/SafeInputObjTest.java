import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

class SafeInputObjTest {

    SafeInputObj p1;

    Scanner in = new Scanner(System.in);

    @BeforeEach
    void setUp() {
        p1 = new SafeInputObj(in);
    }

    @Test
    void getNonZeroLenString() {
        assertEquals("Hello", SafeInputObj.getNonZeroLenString("What do you say when greeting someone? "));
    }

    @Test
    void getRangedInt() {
        assertEquals(20, SafeInputObj.getRangedInt("How old are you? ", 10, 99));
    }

    @Test
    void getInt() {
        assertEquals(2025, SafeInputObj.getInt("What year is it? "));
    }

    @Test
    void getRangedDouble() {
        assertEquals(20, SafeInputObj.getRangedDouble("How old are you? ", 10, 99));
    }

    @Test
    void getDouble() {
        assertEquals(2025, SafeInputObj.getDouble("What year is it? "));
    }

    @Test
    void getYNConfirm() {
        assertEquals(true, SafeInputObj.getYNConfirm("Is this working? "));
    }

    @Test
    void getRegExString() {
        assertEquals("%-2.2f", SafeInputObj.getRegExString("Enter a reg ex pattern ", "%-2.2f"));
    }
}