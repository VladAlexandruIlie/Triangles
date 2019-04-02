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

            rawInputs.addAll(findPositiveNumbers(line));

            ArrayList<Float> parsedInputs = new ArrayList<>(selectInputs(rawInputs));

            if (isTriangleDimensions(parsedInputs)) {
                if (triangleInequality(parsedInputs.get(0), parsedInputs.get(1), parsedInputs.get(2))) {
                    Polygon triangle = new Triangle(parsedInputs);
                    triangle.determine();
                    System.out.println(triangle.getEdges());
                    System.out.println("Triangle type: " + triangle.getType());
                }
                else {
                    System.out.println("Invalid edge lengths !");
                }
                rawInputs.clear();
            }
        }
        sc.close();
    }
}
