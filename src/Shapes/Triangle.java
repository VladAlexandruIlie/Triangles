package Shapes;

import java.util.ArrayList;

import static Utilities.Utils.triangleInequality;

public class Triangle extends Polygon{
    public enum TYPE {invalid, scalar, isosceles, equilateral}


    public Triangle(ArrayList<Float> input) {
        super(input);
    }

    public void determine(){
        Float a = getEdges().get(0);
        Float b = getEdges().get(1);
        Float c = getEdges().get(2);
        if (!triangleInequality(a,b,c)) this.type = TYPE.invalid;
        else if (a.equals(b) && a.equals(c)) this.type = TYPE.equilateral ;
        else if (a.equals(b) || a.equals(c) || b.equals(c)) this.type=TYPE.isosceles;
        else this.type = TYPE.scalar;
    }

    public Enum getType() {
        return type;
    }
}
