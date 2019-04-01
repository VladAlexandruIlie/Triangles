import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static Utilities.Utils.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void findNumbersTest1() {
        String line = "1 2 3";
        ArrayList<Float> inputs = findNumbers(line);

        ArrayList<Float> expectedInputs = new ArrayList<>();
        expectedInputs.add((float) 1);
        expectedInputs.add((float) 2);
        expectedInputs.add((float) 3);

        assertEquals(expectedInputs,inputs);
    }

    @Test
    void findNumbersTest2() {
        String line = "1.1 2.4 3.5";
        ArrayList<Float> inputs = findNumbers(line);

        ArrayList<Float> expectedInputs = new ArrayList<>();
        expectedInputs.add((float) 1.1);
        expectedInputs.add((float) 2.4);
        expectedInputs.add((float) 3.5);

        assertEquals(expectedInputs,inputs);
    }

    @Test
    void findNumbersTest3() {
        String line = "asd 12.lads,.13.2,q21.00 asd.1,23";
        ArrayList<Float> inputs = findNumbers(line);

        ArrayList<Float> expectedInputs = new ArrayList<>();
        expectedInputs.add((float) 12);
        expectedInputs.add((float) 13.2);
        expectedInputs.add((float) 21);
        expectedInputs.add((float) 1);
        expectedInputs.add((float) 23);

        assertEquals(expectedInputs,inputs);
    }

    @Test
    void findNumbersTest4() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String line = "-1 2 4";
        ArrayList<Float> inputs = findNumbers(line);

        ArrayList<Float> expectedInputs = new ArrayList<>();
        expectedInputs.add((float) 2);
        expectedInputs.add((float) 4);

        assertEquals("Cannot have negative edge length or equal to zero !\n", outContent.toString());
        assertEquals(expectedInputs,inputs);
    }

    @Test
    void findNumbersTest5() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String line = "-1.3 4.5 -10";
        ArrayList<Float> inputs = findNumbers(line);

        ArrayList<Float> expectedInputs = new ArrayList<>();
        expectedInputs.add((float) 4.5);

        assertEquals("Cannot have negative edge length or equal to zero !\n", outContent.toString());
        assertEquals(expectedInputs,inputs);
    }

    @Test
    void viableDimensionsTest1() {
        assertTrue(viableDimensions((float) 2, (float) 3, (float) 4));
    }

    @Test
    void viableDimensionsTest2() {
        assertTrue(viableDimensions((float) 2.4, (float) 3.1, (float) 4.6));
    }

    @Test
    void viableDimensionsTest3() {
        assertFalse(viableDimensions((float) 1, (float) 2, (float) 3));
    }

    @Test
    void viableDimensionsTest4() {
        assertFalse(viableDimensions((float) 1.5, (float) 2.5, (float) 4));
    }

    @Test
    void selectInputsTest1() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ArrayList<Float> rawInputs = new ArrayList<>();
        rawInputs.add((float) 3);
        rawInputs.add((float) 5);

        ArrayList<Float> paresedInput = selectInputs(rawInputs);

        ArrayList<Float> expectedParsedInputs = new ArrayList<>();
        expectedParsedInputs.add((float) 3);
        expectedParsedInputs.add((float) 5);

        assertEquals("Add 1 number(s).\n", outContent.toString());
        assertEquals(expectedParsedInputs,paresedInput);
    }

    @Test
    void selectInputsTest2() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ArrayList<Float> rawInputs = new ArrayList<>();
        rawInputs.add((float) 3);
        rawInputs.add((float) 4);
        rawInputs.add((float) 5);
        rawInputs.add((float) 6);
        rawInputs.add((float) 7);

        ArrayList<Float> paresedInput = selectInputs(rawInputs);

        ArrayList<Float> expectedParsedInputs = new ArrayList<>();
        expectedParsedInputs.add((float) 3);
        expectedParsedInputs.add((float) 4);
        expectedParsedInputs.add((float) 5);

        assertEquals("Added too many numbers, using the first 3.\n", outContent.toString());
        assertEquals(expectedParsedInputs,paresedInput);
    }

    @Test
    void selectInputsTest3() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ArrayList<Float> rawInputs = new ArrayList<>();
        rawInputs.add((float) 3);
        rawInputs.add((float) 5);
        rawInputs.add((float) 4);

        ArrayList<Float> paresedInput = selectInputs(rawInputs);

        ArrayList<Float> expectedParsedInputs = new ArrayList<>();
        expectedParsedInputs.add((float) 3);
        expectedParsedInputs.add((float) 5);
        expectedParsedInputs.add((float) 4);

        assertEquals("Enough numbers to make a triangle.\n", outContent.toString());
        assertEquals(expectedParsedInputs,paresedInput);
    }

}