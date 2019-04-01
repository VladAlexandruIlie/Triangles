import Shapes.Polygon;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolygonTest {

    @Test
    void determineTypeTest1() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ArrayList<Float> rawInputs = new ArrayList<>();
        rawInputs.add((float) 3);
        rawInputs.add((float) 5);

        Polygon polygon = new Polygon(rawInputs);
        polygon.determineType();

        assertEquals("Add 1 number(s).\n", outContent.toString());
        assertEquals("", polygon.getType());
    }

    @Test
    void determineTypeTest2() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ArrayList<Float> rawInputs = new ArrayList<>();
        rawInputs.add((float) 3);
        rawInputs.add((float) 4);
        rawInputs.add((float) 5);
        rawInputs.add((float) 6);
        rawInputs.add((float) 7);

        Polygon polygon = new Polygon(rawInputs);
        polygon.determineType();

        assertEquals("Added too many numbers, using the first 3.\n", outContent.toString());
        assertEquals("triangle", polygon.getType());
    }

    @Test
    void determineTypeTest3() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ArrayList<Float> rawInputs = new ArrayList<>();
        rawInputs.add((float) 3.2);
        rawInputs.add((float) 4.1);
        rawInputs.add((float) 2.8);

        Polygon polygon = new Polygon(rawInputs);
        polygon.determineType();

        assertEquals("", outContent.toString());
        assertEquals("triangle", polygon.getType());
    }

    @Test
    void determineTypeTest4() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ArrayList<Float> rawInputs = new ArrayList<>();
        rawInputs.add((float) 1.1);
        rawInputs.add((float) 2.1);
        rawInputs.add((float) 5.3);

        Polygon polygon = new Polygon(rawInputs);
        polygon.determineType();

        assertEquals("Invalid numbers; triangle inequality is not satisfied !\n", outContent.toString());
        assertEquals("invalid", polygon.getType());
    }
}



//    @Test
//    void selectInputsTest1() {
//        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        ArrayList<Float> rawInputs = new ArrayList<>();
//        rawInputs.add((float) 3);
//        rawInputs.add((float) 5);
//
//        ArrayList<Float> paresedInput = selectInputs(rawInputs);
//
//        ArrayList<Float> expectedParsedInputs = new ArrayList<>();
//        expectedParsedInputs.add((float) 3);
//        expectedParsedInputs.add((float) 5);
//
//        assertEquals("Add 1 number(s).\n", outContent.toString());
//        assertEquals(expectedParsedInputs,paresedInput);
//    }
//
//    @Test
//    void selectInputsTest2() {
//        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        ArrayList<Float> rawInputs = new ArrayList<>();
//        rawInputs.add((float) 3);
//        rawInputs.add((float) 4);
//        rawInputs.add((float) 5);
//        rawInputs.add((float) 6);
//        rawInputs.add((float) 7);
//
//        ArrayList<Float> paresedInput = selectInputs(rawInputs);
//
//        ArrayList<Float> expectedParsedInputs = new ArrayList<>();
//        expectedParsedInputs.add((float) 3);
//        expectedParsedInputs.add((float) 4);
//        expectedParsedInputs.add((float) 5);
//
//        assertEquals("Added too many numbers, using the first 3.\n", outContent.toString());
//        assertEquals(expectedParsedInputs,paresedInput);
//    }
//
//    @Test
//    void selectInputsTest3() {
//        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        ArrayList<Float> rawInputs = new ArrayList<>();
//        rawInputs.add((float) 3);
//        rawInputs.add((float) 5);
//        rawInputs.add((float) 4);
//
//        ArrayList<Float> paresedInput = selectInputs(rawInputs);
//
//        ArrayList<Float> expectedParsedInputs = new ArrayList<>();
//        expectedParsedInputs.add((float) 3);
//        expectedParsedInputs.add((float) 5);
//        expectedParsedInputs.add((float) 4);
//
//        assertEquals("Enough numbers to make a triangle.\n", outContent.toString());
//        assertEquals(expectedParsedInputs,paresedInput);