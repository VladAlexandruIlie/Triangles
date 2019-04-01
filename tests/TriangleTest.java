import Shapes.Polygon;
import Shapes.Triangle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest {

    @Test
    void getTypeTest1() {
        ArrayList<Float> edges = new ArrayList<>();
        edges.add((float) 1);
        edges.add((float) 2);
        edges.add((float) 3);

        Polygon triangle = new Triangle(edges);

        assertEquals("scalar", triangle.getType() );
    }

    @Test
    void getTypeTest2() {
        ArrayList<Float> edges = new ArrayList<>();
        edges.add((float) 2);
        edges.add((float) 2);
        edges.add((float) 3);

        Polygon triangle = new Triangle(edges);
        assertEquals("isosceles", triangle.getType());
    }

    @Test
    void getTypeTest3() {
        ArrayList<Float> edges = new ArrayList<>();
        edges.add((float) 3);
        edges.add((float) 3);
        edges.add((float) 3);

        Polygon triangle = new Triangle(edges);
        assertEquals("equilateral", triangle.getType() );
    }

    @Test
    void getTypeTest4() {
        ArrayList<Float> edges = new ArrayList<>();
        edges.add((float) 1.8);
        edges.add((float) 2.1);
        edges.add((float) 3.2);

        Polygon triangle = new Triangle(edges);
        assertEquals("scalar", triangle.getType() );
    }

    @Test
    void getTypeTest5() {
        ArrayList<Float> edges = new ArrayList<>();
        edges.add((float) 2.2);
        edges.add((float) 2.2);
        edges.add((float) 3.7);

        Polygon triangle = new Triangle(edges);
        assertEquals("isosceles", triangle.getType() );
    }

    @Test
    void getTypeTest6() {
        ArrayList<Float> edges = new ArrayList<>();
        edges.add((float) 3.3);
        edges.add((float) 3.3);
        edges.add((float) 3.3);

        Polygon triangle = new Triangle(edges);
        assertEquals("equilateral", triangle.getType() );
    }
}