import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hey, Triangles project !");

        Scanner sc = new Scanner(System.in);

        System.out.println("Write 3 numbers: ");
        ArrayList<Float> inputs = new ArrayList<Float>();

        while (sc.hasNext()){
            String line = sc.nextLine();

            if (line.equals("quit"))
                System.exit(0);

            ArrayList<Float> lineInputs = findNumbers(line);
            inputs.addAll(lineInputs);

            ArrayList<Float> paresed = selectInputs(inputs);
            if (paresed.size()==3) {
                printInputs(paresed);
                if (viableDimensions(paresed.get(0),paresed.get(1),paresed.get(2))){
                    Triangle triangle = new Triangle(paresed.get(0),paresed.get(1),paresed.get(2));
                    System.out.println("Triangle type: " + triangle.getType());
                }
                else System.out.println("Invalid numbers to create a triangle");
                inputs.clear();
            }
        }

    }

    protected static ArrayList<Float> findNumbers(String line) {
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

    protected static boolean viableDimensions(Float a, Float b, Float c) {
        if (a + b <= c) return false;
        else if (a + c <= b) return false;
        else if (b + c <= a) return false;
        return true;
    }

    protected static ArrayList<Float> selectInputs(ArrayList<Float> inputs) {
        ArrayList<Float> paresInputs = new ArrayList<>();
        if (inputs.size() < 3 ){
            System.out.println("Add " + (3 - inputs.size()) + " numbers.");
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

    protected static void printInputs(ArrayList<Float> inputs){
        System.out.println("Edge lengths: " + inputs.toString());
    }
}
