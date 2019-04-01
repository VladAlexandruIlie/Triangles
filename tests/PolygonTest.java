package Shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolygonTest {

    @Test
    void determineType() {
    }
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