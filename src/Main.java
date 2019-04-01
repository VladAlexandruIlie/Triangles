import Shapes.Polygon;
import Shapes.Triangle;

import java.util.ArrayList;
import java.util.Scanner;

import static Utilities.Utils.*;


public class Main {

    public static void main(String[] args) {
        System.out.println("Input the lengths of a triangle's three sides: ");

        Scanner sc = new Scanner(System.in);
        ArrayList<Float> rawInputs = new ArrayList<>();

        while (sc.hasNext()){
            String line = sc.nextLine();

            if (line.equals("quit"))
                System.exit(0);

            rawInputs.addAll(findNumbers(line));

            Polygon polygon = new Polygon(rawInputs);
            polygon.determineType();
            polygon.printInputs();

            if (polygon.getType().equals("triangle")){
                Polygon triangle = new Triangle(polygon.getEdges());
                System.out.println("Triangle type: " + triangle.getType());
                rawInputs.clear();
            }
            else if (polygon.getType().equals("invalid")){
                rawInputs.clear();
            }
        }
    }
}
