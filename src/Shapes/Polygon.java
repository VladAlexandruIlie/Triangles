package Shapes;

import java.util.ArrayList;

import static Utilities.Utils.viableDimensions;

public class Polygon {
    private ArrayList<Float> edgeLengths;
    private String type="";

    public Polygon(ArrayList<Float> input) {
        this.edgeLengths =input;
    }

    public void determineType() {
        if (edgeLengths.size() == 3) {
            if (viableDimensions(edgeLengths.get(0), edgeLengths.get(1), edgeLengths.get(2))){
                type = "triangle";
            }
            else {
                System.out.println("Invalid numbers; triangle inequality is not satisfied !");
                type="invalid";
            }

        }
        else if (edgeLengths.size() < 3){
            System.out.println("Add " + (3 - edgeLengths.size()) + " number(s).");
        }
        else {
            System.out.println("Added too many numbers, using the first 3.");
            this.edgeLengths = new ArrayList<>(edgeLengths.subList(0,3));
            determineType();
        }
//        printInputs(edgeLengths);
    }

    public String getType() {
        return type;
    }

    public ArrayList<Float> getEdges() {
        return edgeLengths;
    }

    public void printInputs(){
        System.out.println("Edges length: " + this.edgeLengths.toString());
    }
}
