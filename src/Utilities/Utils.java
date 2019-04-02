package Utilities;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private Utils(){}

    public static ArrayList<Float> findPositiveNumbers(String line) {
        ArrayList<Float> lineInputs = new ArrayList<>();

        Pattern pattern = Pattern.compile("(-?\\d+[.]?\\d*|-?\\d+)");
        Matcher matcher = pattern.matcher(line);

        boolean sw = false;
        while (matcher.find()){
            String inputNumber = matcher.group(0);

            if (Float.parseFloat(inputNumber) > 0 )
                lineInputs.add(Float.parseFloat(inputNumber));
            else if (!sw) {
                sw=true;
                System.out.println("Cannot have negative edge length or equal to zero !");
            }
        }
        return lineInputs;
    }

    public static ArrayList<Float> selectInputs(ArrayList<Float> inputs) {
        ArrayList<Float> paresInputs;

        if (inputs.size() < 3 ){
            System.out.println("Add " + (3 - inputs.size()) + " number(s).");
            paresInputs = new ArrayList<>(inputs);
        }
        else if (inputs.size() > 3) {
            System.out.println("Added too many numbers, using the first 3.");
            paresInputs = new ArrayList<>(inputs.subList(0,3));
        }
        else {
            System.out.println("Exact numbers to make a triangle.");
            paresInputs = new ArrayList<>(inputs);
        }
        return paresInputs;
    }

    public static boolean isTriangleDimensions(ArrayList<Float> parsedInputs) {
        return parsedInputs.size() == 3;
    }

    public static boolean triangleInequality(Float a, Float b, Float c) {
        return !(b + c <= a) && !(a + c <= b) && !(a + b <= c);
    }
}
