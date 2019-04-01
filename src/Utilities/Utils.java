import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static ArrayList<Float> findNumbers(String line) {
        ArrayList<Float> lineInputs = new ArrayList<Float>();

        Pattern pattern = Pattern.compile("(-?\\d+[.]?\\d*|-?\\d+)");
        Matcher matcher = pattern.matcher(line);

        int ct = 0;
        while (matcher.find()){
            String inputNumber = matcher.group(0);

            if (Float.parseFloat(inputNumber) > 0 )
                lineInputs.add(Float.parseFloat(inputNumber));
            else if (ct == 0 ) {
                ct += 1;
                System.out.println("Cannot have negative edge length or equal to zero !");
            }
        }
        return lineInputs;
    }

    public static boolean viableDimensions(Float a, Float b, Float c) {
        return !(b + c <= a) && !(a + c <= b) && !(a + b <= c);
    }

    public static ArrayList<Float> selectInputs(ArrayList<Float> inputs) {
        ArrayList<Float> paresInputs;

        if (inputs.size() < 3 ){
            System.out.println("Add " + (3 - inputs.size()) + " number(s).");
            paresInputs = new ArrayList<Float>(inputs);
        }
        else if (inputs.size() > 3) {
            System.out.println("Added too many numbers, using the first 3.");
            paresInputs = new ArrayList<Float>(inputs.subList(0,3));
        }
        else {
            System.out.println("Enough numbers to make a triangle.");
            paresInputs = new ArrayList<Float>(inputs);
        }
        return paresInputs;
    }

    public static void printInputs(ArrayList<Float> inputs){
        System.out.println("Edge lengths: " + inputs.toString());
    }
}
