package Shapes;

import java.util.ArrayList;

public class Polygon {
    private ArrayList<Float> edgeLengths;
    Enum type;

    Polygon(ArrayList<Float> input) {
        this.edgeLengths = input;
    }

    public void determine() {
    }

    public Enum getType() {
        return type;
    }

    public ArrayList<Float> getEdges() {
        return edgeLengths;
    }
}
